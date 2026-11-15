package com.jcd.service.qafa.impl;

import com.jcd.dto.qafa.QaFaCreateRecordDto;
import com.jcd.dto.qafa.QaFaItemValueDto;
import com.jcd.dto.qafa.QaFaSaveProdDto;
import com.jcd.dto.qafa.QaFaSaveQcDto;
import com.jcd.dto.qafa.QaFaStageJudgeDto;
import com.jcd.dto.qafa.QaFaTransitionDto;
import com.jcd.exception.BusinessException;
import com.jcd.mapper.qafa.QaFaAuditLogMapper;
import com.jcd.mapper.qafa.QaFaLabDataMapper;
import com.jcd.mapper.qafa.QaFaRecordMapper;
import com.jcd.mapper.qafa.QaFaStageResultMapper;
import com.jcd.mapper.qafa.QaFaTemplateMapper;
import com.jcd.model.Prp_lot;
import com.jcd.model.qafa.*;
import com.jcd.service.MesService;
import com.jcd.service.qafa.QaFaRecordService;
import com.jcd.service.qafa.QaFaTemplateRuleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class QaFaRecordServiceImpl implements QaFaRecordService {

    /* ====== 状态常量 ====== */
    public static final String S_DRAFT          = "DRAFT";
    public static final String S_PROD_SUBMITTED = "PROD_SUBMITTED";
    public static final String S_QC_REVIEWING   = "QC_REVIEWING";
    public static final String S_APPROVED       = "APPROVED";
    public static final String S_REJECTED       = "REJECTED";
    public static final String S_VOID           = "VOID";

    public static final String ST_PENDING = "PENDING";
    public static final String ST_PASS    = "PASS";
    public static final String ST_FAIL    = "FAIL";
    public static final String ST_NA      = "NA";

    /* ====== Action 常量 ====== */
    public static final String A_CREATE       = "CREATE";
    public static final String A_PROD_SAVE    = "PROD_SAVE";
    public static final String A_PROD_SUBMIT  = "PROD_SUBMIT";
    public static final String A_QC_TAKE      = "QC_TAKE";
    public static final String A_QC_SAVE      = "QC_SAVE";
    public static final String A_QC_APPROVE   = "QC_APPROVE";
    public static final String A_QC_REJECT    = "QC_REJECT";
    public static final String A_QC_RETURN    = "QC_RETURN";
    public static final String A_STAGE_PASS    = "QC_STAGE_PASS";
    public static final String A_STAGE_FAIL    = "QC_STAGE_FAIL";
    public static final String A_VOID         = "VOID";

    @Autowired private QaFaRecordMapper      recordMapper;
    @Autowired private QaFaTemplateMapper    templateMapper;
    @Autowired private QaFaStageResultMapper stageResultMapper;
    @Autowired private QaFaLabDataMapper     labDataMapper;
    @Autowired private QaFaAuditLogMapper    auditLogMapper;
    @Autowired private MesService            mesService;

    /* ===================================================================== */

    @Override
    public Map<String, Object> checkLot(String lotName) {
        if (!StringUtils.hasText(lotName)) {
            throw new BusinessException(400, "批次号不能为空");
        }
        List<Prp_lot> lots = mesService.lotfindbyLotname(lotName);
        if (CollectionUtils.isEmpty(lots)) {
            throw new BusinessException(404, "未找到该批次: " + lotName);
        }
        Prp_lot lot = lots.get(0);

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("lotId",     lot.getLotid());
        data.put("lotName",   lot.getLotname());
        data.put("productPn", lot.getProductpn());
        data.put("totalQty",  lot.getTotalqty());
        data.put("panelPcs",  lot.getPanelpcs());
        data.put("lineCode",  lot.getLineid());
        data.put("sampleQty", 2);
        data.put("sampleUnit", "PNL");

        // 同批次的历史首件(供前端提示是否要继续新建)
        List<QaFaRecord> existing = recordMapper.selectByLotName(lot.getLotname());
        attachStageSummaries(existing);
        List<Map<String, Object>> brief = existing.stream().map(r -> {
            Map<String, Object> m = new LinkedHashMap<>();
            m.put("id", r.getId());
            m.put("recordNo", r.getRecordNo());
            m.put("status", r.getStatus());
            m.put("processCode", r.getProcessCode());
            m.put("createTime", r.getCreateTime());
            m.put("stageSummaryText", r.getStageSummaryText());
            m.put("stageSummaryStatus", r.getStageSummaryStatus());
            m.put("stageProgressText", r.getStageProgressText());
            m.put("productionReleased", r.getProductionReleased());
            return m;
        }).collect(Collectors.toList());
        data.put("existingRecords", brief);

        return data;
    }

    /* ===================================================================== */

    @Override
    @Transactional
    public QaFaRecord createRecord(QaFaCreateRecordDto dto, String userId, String userName) {
        if (dto == null || !StringUtils.hasText(dto.getTemplateId()) || !StringUtils.hasText(dto.getLotName())) {
            throw new BusinessException(400, "templateId 与 lotName 必填");
        }
        QaFaTemplate tpl = templateMapper.selectById(dto.getTemplateId());
        if (tpl == null) {
            throw new BusinessException(404, "模板不存在");
        }
        // 反查 prp_lot
        List<Prp_lot> lots = mesService.lotfindbyLotname(dto.getLotName());
        if (CollectionUtils.isEmpty(lots)) {
            throw new BusinessException(404, "未找到该批次: " + dto.getLotName());
        }
        Prp_lot lot = lots.get(0);

        Date now = new Date();
        QaFaRecord rec = new QaFaRecord();
        rec.setId(uuid());
        rec.setRecordNo(genRecordNo());
        rec.setTemplateId(tpl.getId());
        rec.setProcessCode(tpl.getProcessCode());
        rec.setLotId(lot.getLotid());
        rec.setLotName(lot.getLotname());
        rec.setProductPn(lot.getProductpn());
        rec.setLineCode(dto.getLineCode());
        rec.setSampleQty(dto.getSampleQty() == null ? 2 : dto.getSampleQty());
        rec.setSampleUnit(normalizeSampleUnit(dto.getSampleUnit()));
        rec.setSampleTime(dto.getSampleTime() == null ? now : dto.getSampleTime());
        rec.setStatus(S_DRAFT);
        rec.setCurrentRound(1);
        rec.setProdUserId(userId);
        rec.setProdUserName(userName);
        rec.setCreateTime(now);
        rec.setUpdateTime(now);
        recordMapper.insert(rec);

        // 按模板生成 round=1 的所有 record_item (空值)
        List<QaFaTemplateItem> items = templateMapper.selectItemsByTemplateId(tpl.getId());
        List<QaFaTemplateSection> sections = templateMapper.selectSectionsByTemplateId(tpl.getId());
        Map<String, String> sectionCodeMap = sections.stream()
                .collect(Collectors.toMap(QaFaTemplateSection::getId, QaFaTemplateSection::getCode));
        if (!items.isEmpty()) {
            List<QaFaRecordItem> rows = new ArrayList<>(items.size());
            for (QaFaTemplateItem it : items) {
                QaFaRecordItem ri = new QaFaRecordItem();
                ri.setId(uuid());
                ri.setRecordId(rec.getId());
                ri.setTemplateItemId(it.getId());
                ri.setSectionCode(sectionCodeMap.get(it.getSectionId()));
                ri.setItemCode(it.getCode());
                ri.setItemName(it.getName());
                ri.setRoundNo(1);
                rows.add(ri);
            }
            recordMapper.batchInsertItems(rows);
        }
        ensureStageResults(rec);
        writeAudit(rec.getId(), null, S_DRAFT, A_CREATE, userId, userName, null);
        return rec;
    }

    /* ===================================================================== */

    @Override
    public Map<String, Object> getDetail(String recordId) {
        QaFaRecord rec = mustGet(recordId);
        Map<String, Object> tplDetail = new HashMap<>();
        List<QaFaTemplateItem> templateItems = templateMapper.selectItemsByTemplateId(rec.getTemplateId());
        QaFaTemplateRuleUtil.applyRuleFields(templateItems);
        tplDetail.put("template", templateMapper.selectById(rec.getTemplateId()));
        tplDetail.put("sections", templateMapper.selectSectionsByTemplateId(rec.getTemplateId()));
        tplDetail.put("items",    templateItems);

        List<QaFaRecordItem> currentItems = recordMapper.selectItemsByRecordAndRound(recordId, rec.getCurrentRound());
        List<QaFaStageResult> stageResults = ensureStageResults(rec);
        Map<String, Object> stageSummary = buildStageSummary(rec, stageResults);
        applyStageSummary(rec, stageSummary);
        List<QaFaLabData> labList = labDataMapper.selectByRecordId(recordId);
        // 顺手展开 lab item
        List<Map<String, Object>> labMaps = new ArrayList<>();
        for (QaFaLabData l : labList) {
            Map<String, Object> m = new LinkedHashMap<>();
            m.put("data", l);
            m.put("items", labDataMapper.selectItemsByLabDataId(l.getId()));
            labMaps.add(m);
        }
        List<QaFaAuditLog> logs = auditLogMapper.selectByRecordId(recordId);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("record", rec);
        result.put("template", tplDetail);
        result.put("items", currentItems);
        result.put("stageResults", stageResults);
        result.put("stageSummary", stageSummary);
        result.put("labData", labMaps);
        result.put("auditLogs", logs);
        return result;
    }

    /* ===================================================================== */

    @Override
    @Transactional
    public void saveProd(String recordId, QaFaSaveProdDto dto, String userId, String userName) {
        QaFaRecord rec = mustGet(recordId);
        if (!S_DRAFT.equals(rec.getStatus()) && !S_PROD_SUBMITTED.equals(rec.getStatus())) {
            throw new BusinessException(409, "当前状态不允许生产端编辑: " + rec.getStatus());
        }
        // PROD_SUBMITTED 阶段, 若品管已接单(qcUserId存在)就不允许改
        if (S_PROD_SUBMITTED.equals(rec.getStatus()) && rec.getQcUserId() != null) {
            throw new BusinessException(409, "品管已接单, 无法再编辑");
        }
        // 更新线别与检验数
        QaFaRecord upd = new QaFaRecord();
        upd.setId(rec.getId());
        upd.setUpdateTime(new Date());
        if (dto.getLineCode() != null) upd.setLineCode(dto.getLineCode());
        if (dto.getSampleQty() != null) upd.setSampleQty(dto.getSampleQty());
        if (dto.getSampleUnit() != null) upd.setSampleUnit(dto.getSampleUnit());
        recordMapper.updateSelective(upd);
        validateForceRangePass(rec, dto.getItems(), "PROD");
        upsertItems(rec, dto.getItems(), userId, true);
        writeAudit(rec.getId(), rec.getStatus(), rec.getStatus(), A_PROD_SAVE, userId, userName, null);
    }

    @Override
    @Transactional
    public void submitProd(String recordId, String userId, String userName) {
        QaFaRecord rec = mustGet(recordId);
        if (!S_DRAFT.equals(rec.getStatus()) && !S_PROD_SUBMITTED.equals(rec.getStatus())) {
            throw new BusinessException(409, "当前状态不允许提交: " + rec.getStatus());
        }
        // 校验生产端必填项
        validateRequiredItems(rec, "PROD");
        validateForceRangeItems(rec, "PROD");

        Date now = new Date();
        QaFaRecord upd = new QaFaRecord();
        upd.setId(rec.getId());
        upd.setStatus(S_PROD_SUBMITTED);
        upd.setProdUserId(userId);
        upd.setProdUserName(userName);
        upd.setProdSubmitTime(now);
        upd.setRejectReason("");
        upd.setUpdateTime(now);
        recordMapper.updateSelective(upd);
        writeAudit(rec.getId(), rec.getStatus(), S_PROD_SUBMITTED, A_PROD_SUBMIT, userId, userName, null);
    }

    /* ===================================================================== */

    @Override
    @Transactional
    public void saveQc(String recordId, QaFaSaveQcDto dto, String userId, String userName) {
        QaFaRecord rec = mustGet(recordId);
        // 自动接单
        if (S_PROD_SUBMITTED.equals(rec.getStatus())) {
            takeOver(rec, userId, userName);
            rec = mustGet(recordId);
        }
        if (!S_QC_REVIEWING.equals(rec.getStatus())) {
            throw new BusinessException(409, "当前状态不允许品管编辑: " + rec.getStatus());
        }
        if (rec.getQcUserId() != null && !rec.getQcUserId().equals(userId)) {
            throw new BusinessException(403, "已被其他品管接单: " + rec.getQcUserName());
        }
        validateQcNgRemarks(rec, dto.getItems());
        validateForceRangePass(rec, dto.getItems(), "QC");
        upsertItems(rec, dto.getItems(), userId, false);
        if (StringUtils.hasText(dto.getProblemDesc())) {
            QaFaRecord upd = new QaFaRecord();
            upd.setId(rec.getId());
            upd.setProblemDesc(dto.getProblemDesc());
            upd.setUpdateTime(new Date());
            recordMapper.updateSelective(upd);
        }
        writeAudit(rec.getId(), rec.getStatus(), rec.getStatus(), A_QC_SAVE, userId, userName, null);
    }

    private void takeOver(QaFaRecord rec, String userId, String userName) {
        Date now = new Date();
        QaFaRecord upd = new QaFaRecord();
        upd.setId(rec.getId());
        upd.setStatus(S_QC_REVIEWING);
        upd.setQcUserId(userId);
        upd.setQcUserName(userName);
        upd.setQcReviewTime(now);
        upd.setUpdateTime(now);
        recordMapper.updateSelective(upd);
        writeAudit(rec.getId(), S_PROD_SUBMITTED, S_QC_REVIEWING, A_QC_TAKE, userId, userName, null);
    }

    /* ===================================================================== */

    @Override
    @Transactional
    public void transition(String recordId, QaFaTransitionDto dto, String userId, String userName) {
        if (dto == null || !StringUtils.hasText(dto.getAction())) {
            throw new BusinessException(400, "action 必填");
        }
        QaFaRecord rec = mustGet(recordId);
        String action = dto.getAction();
        Date now = new Date();

        switch (action) {
            case A_QC_APPROVE:
                ensureStatus(rec, S_QC_REVIEWING);
                ensureQcOwner(rec, userId);
                List<QaFaStageResult> approveStages = ensureStageResults(rec);
                if (requiresStageReview(approveStages) && !allFinalStagesPass(approveStages)) {
                    throw new BusinessException(409, "当前模板已启用分阶段审核, 请按阶段提交判定");
                }
                if (!StringUtils.hasText(dto.getFinalJudge())) {
                    throw new BusinessException(400, "finalJudge 必填");
                }
                validateRequiredItems(rec, "QC");
                validateForceRangeItems(rec, "QC");
                validateNoQcNgForApprove(rec);
                validateCriticalItemsForApprove(rec);
                ensureLabDataExists(rec);

                QaFaRecord uA = new QaFaRecord();
                uA.setId(rec.getId());
                uA.setStatus(S_APPROVED);
                uA.setFinalJudge(dto.getFinalJudge());
                if (StringUtils.hasText(dto.getProblemDesc())) uA.setProblemDesc(dto.getProblemDesc());
                uA.setUpdateTime(now);
                recordMapper.updateSelective(uA);
                writeAudit(rec.getId(), rec.getStatus(), S_APPROVED, A_QC_APPROVE, userId, userName, dto.getComment());
                break;

            case A_QC_REJECT:
                ensureStatus(rec, S_QC_REVIEWING);
                ensureQcOwner(rec, userId);
                if (!StringUtils.hasText(dto.getComment())) {
                    throw new BusinessException(400, "否决必须填写原因");
                }
                QaFaRecord uR = new QaFaRecord();
                uR.setId(rec.getId());
                uR.setStatus(S_REJECTED);
                uR.setFinalJudge("UNQUALIFIED");
                uR.setRejectReason(dto.getComment());
                if (StringUtils.hasText(dto.getProblemDesc())) uR.setProblemDesc(dto.getProblemDesc());
                uR.setUpdateTime(now);
                recordMapper.updateSelective(uR);
                writeAudit(rec.getId(), rec.getStatus(), S_REJECTED, A_QC_REJECT, userId, userName, dto.getComment());
                break;

            case A_QC_RETURN:
                ensureStatus(rec, S_QC_REVIEWING);
                ensureQcOwner(rec, userId);
                if (!StringUtils.hasText(dto.getComment())) {
                    throw new BusinessException(400, "退回必须填写原因");
                }
                int newRound = (rec.getCurrentRound() == null ? 1 : rec.getCurrentRound()) + 1;
                // 复制一轮新的 record_item (PROD/QC 值清空)
                List<QaFaTemplateItem> items = templateMapper.selectItemsByTemplateId(rec.getTemplateId());
                List<QaFaTemplateSection> secs = templateMapper.selectSectionsByTemplateId(rec.getTemplateId());
                Map<String, String> secMap = secs.stream().collect(Collectors.toMap(QaFaTemplateSection::getId, QaFaTemplateSection::getCode));
                List<QaFaRecordItem> rows = new ArrayList<>();
                for (QaFaTemplateItem it : items) {
                    QaFaRecordItem ri = new QaFaRecordItem();
                    ri.setId(uuid());
                    ri.setRecordId(rec.getId());
                    ri.setTemplateItemId(it.getId());
                    ri.setSectionCode(secMap.get(it.getSectionId()));
                    ri.setItemCode(it.getCode());
                    ri.setItemName(it.getName());
                    ri.setRoundNo(newRound);
                    rows.add(ri);
                }
                if (!rows.isEmpty()) recordMapper.batchInsertItems(rows);

                QaFaRecord uRet = new QaFaRecord();
                uRet.setId(rec.getId());
                uRet.setStatus(S_PROD_SUBMITTED); // 退回后回到生产已提交状态; 接单字段清空让任意品管可重新接
                uRet.setCurrentRound(newRound);
                uRet.setQcUserId(""); // 用空串触发 update; mybatis null 才不更新
                uRet.setQcUserName("");
                uRet.setRejectReason(dto.getComment());
                uRet.setUpdateTime(now);
                recordMapper.updateSelective(uRet);
                writeAudit(rec.getId(), rec.getStatus(), S_PROD_SUBMITTED, A_QC_RETURN, userId, userName, dto.getComment());
                break;

            case A_VOID:
                if (S_VOID.equals(rec.getStatus()) || S_DRAFT.equals(rec.getStatus())) {
                    throw new BusinessException(409, "当前状态无需作废: " + rec.getStatus());
                }
                if (!StringUtils.hasText(dto.getComment())) {
                    throw new BusinessException(400, "作废必须填写原因");
                }
                QaFaRecord uV = new QaFaRecord();
                uV.setId(rec.getId());
                uV.setStatus(S_VOID);
                uV.setUpdateTime(now);
                recordMapper.updateSelective(uV);
                writeAudit(rec.getId(), rec.getStatus(), S_VOID, A_VOID, userId, userName, dto.getComment());
                break;

            default:
                throw new BusinessException(400, "未知 action: " + action);
        }
    }

    @Override
    @Transactional
    public void judgeStage(String recordId, QaFaStageJudgeDto dto, String userId, String userName) {
        if (dto == null || !StringUtils.hasText(dto.getStageCode())) {
            throw new BusinessException(400, "stageCode 必填");
        }
        String judge = normalizeStageJudge(dto.getJudge());
        if (!ST_PASS.equals(judge) && !ST_FAIL.equals(judge)) {
            throw new BusinessException(400, "judge 必须为 PASS 或 FAIL");
        }

        QaFaRecord rec = mustGet(recordId);
        if (S_PROD_SUBMITTED.equals(rec.getStatus())) {
            takeOver(rec, userId, userName);
            rec = mustGet(recordId);
        }
        ensureStatus(rec, S_QC_REVIEWING);
        ensureQcOwner(rec, userId);

        List<QaFaStageResult> stages = ensureStageResults(rec);
        QaFaStageResult stage = findStage(stages, dto.getStageCode());
        if (stage == null) {
            throw new BusinessException(404, "阶段不存在: " + dto.getStageCode());
        }
        if (ST_NA.equals(stage.getStatus())) {
            throw new BusinessException(409, "阶段不适用, 无需判定: " + stage.getStageName());
        }

        if (ST_PASS.equals(judge)) {
            validateRequiredItems(rec, "QC", stage.getStageCode());
            validateForceRangeItems(rec, "QC", stage.getStageCode());
            validateNoQcNgForApprove(rec, stage.getStageCode());
            validateCriticalItemsForApprove(rec, stage.getStageCode());
            ensureLabDataExistsForStage(rec, stage.getStageCode());
        } else if (!StringUtils.hasText(dto.getComment()) && !StringUtils.hasText(dto.getProblemDesc())) {
            throw new BusinessException(400, "阶段不合格必须填写原因");
        }

        Date now = new Date();
        QaFaStageResult upd = new QaFaStageResult();
        upd.setId(stage.getId());
        upd.setStatus(judge);
        upd.setJudgeUserId(userId);
        upd.setJudgeUserName(userName);
        upd.setJudgeTime(now);
        upd.setCommentText(StringUtils.hasText(dto.getComment()) ? dto.getComment() : dto.getProblemDesc());
        upd.setUpdateTime(now);
        stageResultMapper.updateSelective(upd);

        List<QaFaStageResult> refreshedStages = stageResultMapper.selectByRecordId(recordId);
        String newStatus = refreshRecordStatusByStages(rec, refreshedStages, dto, now);
        String action = ST_PASS.equals(judge) ? A_STAGE_PASS : A_STAGE_FAIL;
        String comment = stage.getStageName() + (StringUtils.hasText(upd.getCommentText()) ? ": " + upd.getCommentText() : "");
        writeAudit(rec.getId(), rec.getStatus(), newStatus, action, userId, userName, comment);
    }

    @Override
    @Transactional
    public void deleteRecord(String recordId, String userId) {
        QaFaRecord rec = mustGet(recordId);
        if (rec.getProdUserId() != null && !rec.getProdUserId().equals(userId)) {
            throw new BusinessException(403, "只能删除自己创建的首件记录");
        }
        boolean isDraft = S_DRAFT.equals(rec.getStatus());
        boolean isReturned = S_PROD_SUBMITTED.equals(rec.getStatus())
                && StringUtils.hasText(rec.getRejectReason())
                && !StringUtils.hasText(rec.getQcUserId());
        if (!isDraft && !isReturned) {
            throw new BusinessException(409, "仅草稿或品管退回记录允许删除");
        }
        List<QaFaLabData> labs = labDataMapper.selectByRecordId(recordId);
        for (QaFaLabData lab : labs) {
            labDataMapper.deleteItemsByLabDataId(lab.getId());
            labDataMapper.deleteById(lab.getId());
        }
        recordMapper.deleteItemsByRecordId(recordId);
        recordMapper.deleteAuditLogsByRecordId(recordId);
        stageResultMapper.deleteByRecordId(recordId);
        recordMapper.deleteById(recordId);
    }

    /* ===================================================================== */

    @Override
    public Map<String, Object> queryList(List<String> statusList, String processCode,
                                         String lotName, Date dateFrom, Date dateTo,
                                         String ownerUserId, int pageNo, int pageSize) {
        if (pageNo  < 1) pageNo  = 1;
        if (pageSize < 1) pageSize = 20;
        if (pageSize > 200) pageSize = 200;
        int offset = (pageNo - 1) * pageSize;

        // dateTo 默认是当天 00:00:00, 调整为 23:59:59 包含整天
        if (dateTo != null) {
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(dateTo);
            cal.set(java.util.Calendar.HOUR_OF_DAY, 23);
            cal.set(java.util.Calendar.MINUTE, 59);
            cal.set(java.util.Calendar.SECOND, 59);
            dateTo = cal.getTime();
        }

        int total = recordMapper.queryListCount(statusList, processCode, lotName, dateFrom, dateTo, ownerUserId);
        List<QaFaRecord> list = recordMapper.queryList(statusList, processCode, lotName, dateFrom, dateTo, ownerUserId, offset, pageSize);
        attachStageSummaries(list);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("total", total);
        result.put("pageNo", pageNo);
        result.put("pageSize", pageSize);
        result.put("list", list);
        return result;
    }

    private List<QaFaStageResult> ensureStageResults(QaFaRecord rec) {
        List<QaFaTemplateSection> sections = templateMapper.selectSectionsByTemplateId(rec.getTemplateId());
        if (!isStageReviewConfigured(sections)) {
            return Collections.emptyList();
        }
        List<QaFaStageResult> existing = stageResultMapper.selectByRecordId(rec.getId());
        if (!CollectionUtils.isEmpty(existing)) {
            return existing;
        }
        Date now = new Date();
        List<QaFaStageResult> rows = buildStageResultsFromTemplate(rec, sections, now);
        for (QaFaStageResult row : rows) {
            stageResultMapper.insert(row);
        }
        return stageResultMapper.selectByRecordId(rec.getId());
    }

    private List<QaFaStageResult> buildStageResultsFromTemplate(QaFaRecord rec,
                                                                 List<QaFaTemplateSection> sections,
                                                                 Date now) {
        Map<String, QaFaStageResult> stageMap = new LinkedHashMap<>();
        for (QaFaTemplateSection section : sections) {
            boolean enabled = isOn(section.getStageEnabled(), true);
            String stageCode = section.getStageCode();
            if (!StringUtils.hasText(stageCode)) {
                if (!enabled) continue;
                stageCode = section.getCode();
            }
            if (!StringUtils.hasText(stageCode)) continue;
            QaFaStageResult row = stageMap.get(stageCode);
            boolean finalRequired = enabled && isOn(section.getFinalRequired(), true);
            boolean releaseOnPass = enabled && isOn(section.getReleaseOnPass(), false);
            Integer sortNo = section.getStageSortNo() == null ? section.getSortNo() : section.getStageSortNo();
            if (row == null) {
                row = new QaFaStageResult();
                row.setId(uuid());
                row.setRecordId(rec.getId());
                row.setStageCode(stageCode);
                row.setStageName(stageNameOf(section));
                row.setSortNo(sortNo);
                row.setStatus(enabled ? ST_PENDING : ST_NA);
                row.setFinalRequired(finalRequired ? 1 : 0);
                row.setReleaseOnPass(releaseOnPass ? 1 : 0);
                row.setCreateTime(now);
                row.setUpdateTime(now);
                stageMap.put(stageCode, row);
            } else {
                if (StringUtils.hasText(section.getStageName())) {
                    row.setStageName(section.getStageName());
                }
                if (sortNo != null && (row.getSortNo() == null || sortNo < row.getSortNo())) {
                    row.setSortNo(sortNo);
                }
                if (enabled && ST_NA.equals(row.getStatus())) {
                    row.setStatus(ST_PENDING);
                }
                if (finalRequired) {
                    row.setFinalRequired(1);
                }
                if (releaseOnPass) {
                    row.setReleaseOnPass(1);
                }
            }
        }
        return new ArrayList<>(stageMap.values());
    }

    private boolean isStageReviewConfigured(List<QaFaTemplateSection> sections) {
        if (CollectionUtils.isEmpty(sections)) return false;
        for (QaFaTemplateSection section : sections) {
            if (isOn(section.getStageEnabled(), false) && isOn(section.getReleaseOnPass(), false)) {
                return true;
            }
        }
        return false;
    }

    private void attachStageSummaries(List<QaFaRecord> records) {
        if (CollectionUtils.isEmpty(records)) return;
        for (QaFaRecord rec : records) {
            List<QaFaStageResult> stages = ensureStageResults(rec);
            Map<String, Object> summary = buildStageSummary(rec, stages);
            applyStageSummary(rec, summary);
        }
    }

    private void applyStageSummary(QaFaRecord rec, Map<String, Object> summary) {
        rec.setStageSummaryText((String) summary.get("summaryText"));
        rec.setStageSummaryStatus((String) summary.get("summaryStatus"));
        rec.setStageProgressText((String) summary.get("progressText"));
        rec.setProductionReleased(Boolean.TRUE.equals(summary.get("productionReleased")));
    }

    private Map<String, Object> buildStageSummary(QaFaRecord rec, List<QaFaStageResult> stages) {
        Map<String, Object> summary = new LinkedHashMap<>();
        List<String> parts = new ArrayList<>();
        int finalCount = 0;
        int finalPassCount = 0;
        boolean anyFinalFail = false;
        QaFaStageResult releasePassStage = null;

        for (QaFaStageResult stage : stages) {
            String statusText = stageStatusText(stage.getStatus());
            parts.add(stage.getStageName() + statusText);
            boolean finalRequired = isOn(stage.getFinalRequired(), false) && !ST_NA.equals(stage.getStatus());
            if (finalRequired) {
                finalCount++;
                if (ST_PASS.equals(stage.getStatus())) finalPassCount++;
                if (ST_FAIL.equals(stage.getStatus())) anyFinalFail = true;
            }
            if (isOn(stage.getReleaseOnPass(), false) && ST_PASS.equals(stage.getStatus())) {
                releasePassStage = stage;
            }
        }

        boolean allFinalPass = finalCount > 0 && finalPassCount == finalCount;
        boolean tracking = releasePassStage != null && !allFinalPass && !anyFinalFail;
        String summaryStatus;
        String summaryText;
        if (S_APPROVED.equals(rec.getStatus()) || allFinalPass) {
            summaryStatus = "FINAL_PASS";
            summaryText = "最终合格";
        } else if (S_REJECTED.equals(rec.getStatus()) || anyFinalFail) {
            summaryStatus = "FAIL";
            summaryText = "不合格";
        } else if (tracking) {
            summaryStatus = "TRACKING";
            summaryText = releasePassStage.getStageName() + "合格/可靠性跟踪中";
        } else {
            summaryStatus = "PENDING";
            summaryText = statusText(rec.getStatus());
        }

        summary.put("summaryStatus", summaryStatus);
        summary.put("summaryText", summaryText);
        summary.put("progressText", String.join(" - ", parts));
        boolean productionReleased = releasePassStage != null || S_APPROVED.equals(rec.getStatus());
        summary.put("releasePassed", releasePassStage != null);
        summary.put("productionReleased", productionReleased);
        summary.put("allFinalPass", allFinalPass);
        summary.put("anyFinalFail", anyFinalFail);
        return summary;
    }

    private String refreshRecordStatusByStages(QaFaRecord rec, List<QaFaStageResult> stages,
                                               QaFaStageJudgeDto dto, Date now) {
        boolean anyFinalFail = false;
        int finalCount = 0;
        int finalPassCount = 0;
        for (QaFaStageResult stage : stages) {
            if (!isOn(stage.getFinalRequired(), false) || ST_NA.equals(stage.getStatus())) continue;
            finalCount++;
            if (ST_PASS.equals(stage.getStatus())) finalPassCount++;
            if (ST_FAIL.equals(stage.getStatus())) anyFinalFail = true;
        }

        String newStatus = S_QC_REVIEWING;
        QaFaRecord upd = new QaFaRecord();
        upd.setId(rec.getId());
        upd.setUpdateTime(now);
        if (StringUtils.hasText(dto.getProblemDesc())) {
            upd.setProblemDesc(dto.getProblemDesc());
        }
        if (anyFinalFail) {
            newStatus = S_REJECTED;
            upd.setStatus(S_REJECTED);
            upd.setFinalJudge("UNQUALIFIED");
            upd.setRejectReason(StringUtils.hasText(dto.getComment()) ? dto.getComment() : dto.getProblemDesc());
        } else if (finalCount > 0 && finalPassCount == finalCount) {
            newStatus = S_APPROVED;
            upd.setStatus(S_APPROVED);
            upd.setFinalJudge("QUALIFIED");
        } else if (!S_QC_REVIEWING.equals(rec.getStatus())) {
            upd.setStatus(S_QC_REVIEWING);
        }
        recordMapper.updateSelective(upd);
        return newStatus;
    }

    private boolean requiresStageReview(List<QaFaStageResult> stages) {
        int finalStageCount = 0;
        boolean hasReleaseStage = false;
        for (QaFaStageResult stage : stages) {
            if (ST_NA.equals(stage.getStatus())) continue;
            if (isOn(stage.getFinalRequired(), false)) finalStageCount++;
            if (isOn(stage.getReleaseOnPass(), false)) hasReleaseStage = true;
        }
        return hasReleaseStage || finalStageCount > 1;
    }

    private boolean allFinalStagesPass(List<QaFaStageResult> stages) {
        int finalStageCount = 0;
        int finalPassCount = 0;
        for (QaFaStageResult stage : stages) {
            if (ST_NA.equals(stage.getStatus()) || !isOn(stage.getFinalRequired(), false)) continue;
            finalStageCount++;
            if (ST_PASS.equals(stage.getStatus())) finalPassCount++;
        }
        return finalStageCount > 0 && finalPassCount == finalStageCount;
    }

    private QaFaStageResult findStage(List<QaFaStageResult> stages, String stageCode) {
        if (CollectionUtils.isEmpty(stages) || !StringUtils.hasText(stageCode)) return null;
        for (QaFaStageResult stage : stages) {
            if (stageCode.equals(stage.getStageCode())) return stage;
        }
        return null;
    }

    private Set<String> templateItemIdsForStage(QaFaRecord rec, String stageCode) {
        if (!StringUtils.hasText(stageCode)) return null;
        List<QaFaTemplateItem> items = templateItemsForStage(rec, stageCode);
        return items.stream().map(QaFaTemplateItem::getId).collect(Collectors.toSet());
    }

    private List<QaFaTemplateItem> templateItemsForStage(QaFaRecord rec, String stageCode) {
        List<QaFaTemplateSection> sections = templateMapper.selectSectionsByTemplateId(rec.getTemplateId());
        Set<String> sectionIds = sections.stream()
                .filter(s -> stageCode.equals(stageCodeOf(s)) && isOn(s.getStageEnabled(), true))
                .map(QaFaTemplateSection::getId)
                .collect(Collectors.toSet());
        if (sectionIds.isEmpty()) return Collections.emptyList();
        List<QaFaTemplateItem> items = templateMapper.selectItemsByTemplateId(rec.getTemplateId());
        QaFaTemplateRuleUtil.applyRuleFields(items);
        return items.stream().filter(i -> sectionIds.contains(i.getSectionId())).collect(Collectors.toList());
    }

    private void ensureLabDataExistsForStage(QaFaRecord rec, String stageCode) {
        List<QaFaTemplateItem> items = templateItemsForStage(rec, stageCode);
        boolean requiresLab = false;
        for (QaFaTemplateItem item : items) {
            if ("LAB_LINK".equalsIgnoreCase(item.getInputType())) {
                requiresLab = true;
                break;
            }
        }
        if (!requiresLab) return;
        List<QaFaLabData> labs = labDataMapper.selectByRecordId(rec.getId());
        if (CollectionUtils.isEmpty(labs)) {
            throw new BusinessException(422, "阶段包含实验室关联项, 未上传实验室数据不能判定通过");
        }
    }

    private String stageCodeOf(QaFaTemplateSection section) {
        if (section == null) return "";
        return StringUtils.hasText(section.getStageCode()) ? section.getStageCode() : section.getCode();
    }

    private String stageNameOf(QaFaTemplateSection section) {
        if (section == null) return "";
        return StringUtils.hasText(section.getStageName()) ? section.getStageName() : section.getName();
    }

    private boolean isOn(Integer value, boolean defaultValue) {
        return value == null ? defaultValue : value == 1;
    }

    private String normalizeStageJudge(String judge) {
        if (!StringUtils.hasText(judge)) return "";
        String text = judge.trim().toUpperCase();
        if ("OK".equals(text) || "YES".equals(text) || "QUALIFIED".equals(text)) return ST_PASS;
        if ("NG".equals(text) || "NO".equals(text) || "UNQUALIFIED".equals(text)) return ST_FAIL;
        return text;
    }

    private String stageStatusText(String status) {
        if (ST_PASS.equals(status)) return "合格";
        if (ST_FAIL.equals(status)) return "不合格";
        if (ST_NA.equals(status)) return "不适用";
        return "待审核";
    }

    private String statusText(String status) {
        if (S_DRAFT.equals(status)) return "草稿";
        if (S_PROD_SUBMITTED.equals(status)) return "待接单";
        if (S_QC_REVIEWING.equals(status)) return "审核中";
        if (S_APPROVED.equals(status)) return "合格";
        if (S_REJECTED.equals(status)) return "不合格";
        if (S_VOID.equals(status)) return "已作废";
        return status == null ? "" : status;
    }

    /* ============================ 内部工具 ============================ */

    private QaFaRecord mustGet(String id) {
        QaFaRecord rec = recordMapper.selectById(id);
        if (rec == null) throw new BusinessException(404, "首件记录不存在");
        return rec;
    }

    private void ensureStatus(QaFaRecord rec, String expect) {
        if (!expect.equals(rec.getStatus())) {
            throw new BusinessException(409, "状态不允许操作, 期望:" + expect + " 实际:" + rec.getStatus());
        }
    }

    private void ensureQcOwner(QaFaRecord rec, String userId) {
        if (rec.getQcUserId() == null || !rec.getQcUserId().equals(userId)) {
            throw new BusinessException(403, "仅当前接单品管可操作");
        }
    }

    private void ensureLabDataExists(QaFaRecord rec) {
        List<QaFaLabData> labs = labDataMapper.selectByRecordId(rec.getId());
        if (CollectionUtils.isEmpty(labs)) {
            throw new BusinessException(422, "实验室数据未上传, 不能审批通过");
        }
    }

    /**
     * 校验当前轮次 fillRole 包含给定角色 + required=1 的项均有值
     */
    private void validateRequiredItems(QaFaRecord rec, String role) {
        validateRequiredItems(rec, role, null);
    }

    private void validateRequiredItems(QaFaRecord rec, String role, String stageCode) {
        List<QaFaTemplateItem> items = templateMapper.selectItemsByTemplateId(rec.getTemplateId());
        Set<String> scopedItemIds = templateItemIdsForStage(rec, stageCode);
        boolean stageSubmission = StringUtils.hasText(stageCode);
        List<QaFaRecordItem> filled = recordMapper.selectItemsByRecordAndRound(rec.getId(), rec.getCurrentRound());
        Map<String, QaFaRecordItem> map = filled.stream()
                .collect(Collectors.toMap(QaFaRecordItem::getTemplateItemId, x -> x, (a, b) -> a));

        for (QaFaTemplateItem it : items) {
            if (scopedItemIds != null && !scopedItemIds.contains(it.getId())) continue;
            if (it.getRequired() == null || it.getRequired() != 1) continue;
            String fillRole = it.getFillRole() == null ? "BOTH" : it.getFillRole();
            boolean apply = "BOTH".equals(fillRole) || role.equals(fillRole);
            if (!apply) continue;

            QaFaRecordItem ri = map.get(it.getId());
            String value;
            String pass;
            if ("PROD".equals(role)) {
                value = ri == null ? null : ri.getProdValue();
                pass  = ri == null ? null : ri.getProdPass();
            } else {
                value = ri == null ? null : ri.getQcValue();
                pass  = ri == null ? null : ri.getQcPass();
            }
            if (stageSubmission && isPassFailInput(it)) {
                if (!StringUtils.hasText(pass)) {
                    throw new BusinessException(422, "必填判定未选择OK/NG: " + it.getName());
                }
            } else if (stageSubmission && requiresMeasuredValue(it)) {
                if (!StringUtils.hasText(value)) {
                    throw new BusinessException(422, "必填结果未填写: " + it.getName());
                }
            } else if (!StringUtils.hasText(value) && !StringUtils.hasText(pass)) {
                throw new BusinessException(422, "必填项未填写: " + it.getName());
            }
        }
    }

    private boolean isPassFailInput(QaFaTemplateItem item) {
        String inputType = item == null || item.getInputType() == null
                ? "" : item.getInputType().trim().toUpperCase(Locale.ROOT);
        return "PASS_FAIL".equals(inputType) || "PASSFAIL".equals(inputType);
    }

    private boolean requiresMeasuredValue(QaFaTemplateItem item) {
        String inputType = item == null || item.getInputType() == null
                ? "" : item.getInputType().trim().toUpperCase(Locale.ROOT);
        return !"LAB_LINK".equals(inputType) && !isPassFailInput(item);
    }

    private void validateQcNgRemarks(QaFaRecord rec, List<QaFaItemValueDto> dtos) {
        if (CollectionUtils.isEmpty(dtos)) return;
        List<QaFaTemplateItem> items = templateMapper.selectItemsByTemplateId(rec.getTemplateId());
        Map<String, String> itemNameMap = items.stream()
                .collect(Collectors.toMap(QaFaTemplateItem::getId, QaFaTemplateItem::getName, (a, b) -> a));
        for (QaFaItemValueDto item : dtos) {
            if (item == null || !isNgPass(item.getPass())) continue;
            if (!StringUtils.hasText(item.getRemark())) {
                String itemName = itemNameMap.get(item.getTemplateItemId());
                throw new BusinessException(422, "NG项[" + (itemName == null ? item.getTemplateItemId() : itemName) + "]必须填写问题描述");
            }
        }
    }

    private void validateForceRangePass(QaFaRecord rec, List<QaFaItemValueDto> dtos, String role) {
        if (CollectionUtils.isEmpty(dtos)) return;
        List<QaFaTemplateItem> items = templateMapper.selectItemsByTemplateId(rec.getTemplateId());
        QaFaTemplateRuleUtil.applyRuleFields(items);
        Map<String, QaFaTemplateItem> itemMap = items.stream()
                .collect(Collectors.toMap(QaFaTemplateItem::getId, x -> x, (a, b) -> a));
        for (QaFaItemValueDto dto : dtos) {
            if (dto == null || !isOkPass(dto.getPass())) continue;
            QaFaTemplateItem item = itemMap.get(dto.getTemplateItemId());
            if (item == null || !QaFaTemplateRuleUtil.isForceNg(item)) continue;
            QaFaTemplateRuleUtil.RangeCheckResult result = QaFaTemplateRuleUtil.checkRange(item, dto.getValue());
            if (!result.isPass()) {
                throw new BusinessException(422, rangeError(role, item, result));
            }
        }
    }

    private void validateForceRangeItems(QaFaRecord rec, String role) {
        validateForceRangeItems(rec, role, null);
    }

    private void validateForceRangeItems(QaFaRecord rec, String role, String stageCode) {
        List<QaFaTemplateItem> items = templateMapper.selectItemsByTemplateId(rec.getTemplateId());
        QaFaTemplateRuleUtil.applyRuleFields(items);
        Set<String> scopedItemIds = templateItemIdsForStage(rec, stageCode);
        List<QaFaRecordItem> filled = recordMapper.selectItemsByRecordAndRound(rec.getId(), rec.getCurrentRound());
        Map<String, QaFaRecordItem> filledMap = filled.stream()
                .collect(Collectors.toMap(QaFaRecordItem::getTemplateItemId, x -> x, (a, b) -> a));

        for (QaFaTemplateItem item : items) {
            if (scopedItemIds != null && !scopedItemIds.contains(item.getId())) continue;
            if (!QaFaTemplateRuleUtil.isForceNg(item) || !QaFaTemplateRuleUtil.shouldCheckRange(item)) continue;
            String fillRole = item.getFillRole() == null ? "BOTH" : item.getFillRole();
            boolean apply = "BOTH".equals(fillRole) || role.equals(fillRole);
            if (!apply) continue;

            QaFaRecordItem filledItem = filledMap.get(item.getId());
            String value = null;
            if (filledItem != null) {
                value = "PROD".equals(role) ? filledItem.getProdValue() : filledItem.getQcValue();
            }
            if (!StringUtils.hasText(value)) continue;
            QaFaTemplateRuleUtil.RangeCheckResult result = QaFaTemplateRuleUtil.checkRange(item, value);
            if (!result.isPass()) {
                throw new BusinessException(422, rangeError(role, item, result));
            }
        }
    }

    private String rangeError(String role, QaFaTemplateItem item, QaFaTemplateRuleUtil.RangeCheckResult result) {
        String roleName = "PROD".equals(role) ? "生产" : "品管";
        return roleName + "项[" + item.getName() + "]" + result.getMessage() + ", 已配置强制NG";
    }

    private void validateNoQcNgForApprove(QaFaRecord rec) {
        validateNoQcNgForApprove(rec, null);
    }

    private void validateNoQcNgForApprove(QaFaRecord rec, String stageCode) {
        Set<String> scopedItemIds = templateItemIdsForStage(rec, stageCode);
        List<QaFaRecordItem> filled = recordMapper.selectItemsByRecordAndRound(rec.getId(), rec.getCurrentRound());
        for (QaFaRecordItem item : filled) {
            if (scopedItemIds != null && !scopedItemIds.contains(item.getTemplateItemId())) continue;
            if (!isNgPass(item.getQcPass())) continue;
            if (!StringUtils.hasText(item.getRemark())) {
                throw new BusinessException(422, "NG项[" + item.getItemName() + "]必须填写问题描述");
            }
            throw new BusinessException(422, "存在NG项, 不能审批通过: " + item.getItemName());
        }
    }

    /**
     * 审批前: 关键项 (CRITICAL=1) 的 prodPass 与 qcPass 必须均为 PASS (允许 NA)
     */
    private void validateCriticalItemsForApprove(QaFaRecord rec) {
        validateCriticalItemsForApprove(rec, null);
    }

    private void validateCriticalItemsForApprove(QaFaRecord rec, String stageCode) {
        List<QaFaTemplateItem> items = templateMapper.selectItemsByTemplateId(rec.getTemplateId());
        Set<String> scopedItemIds = templateItemIdsForStage(rec, stageCode);
        List<QaFaRecordItem> filled = recordMapper.selectItemsByRecordAndRound(rec.getId(), rec.getCurrentRound());
        Map<String, QaFaRecordItem> map = filled.stream()
                .collect(Collectors.toMap(QaFaRecordItem::getTemplateItemId, x -> x, (a, b) -> a));

        for (QaFaTemplateItem it : items) {
            if (scopedItemIds != null && !scopedItemIds.contains(it.getId())) continue;
            if (it.getCritical() == null || it.getCritical() != 1) continue;
            QaFaRecordItem ri = map.get(it.getId());
            if (ri == null) {
                throw new BusinessException(422, "关键项缺失: " + it.getName());
            }
            String fillRole = it.getFillRole() == null ? "BOTH" : it.getFillRole();
            // 检查与该项相关的 pass 字段
            if ("BOTH".equals(fillRole) || "PROD".equals(fillRole)) {
                if (!isOkPass(ri.getProdPass())) {
                    throw new BusinessException(422, "关键项[" + it.getName() + "]生产端未通过");
                }
            }
            if ("BOTH".equals(fillRole) || "QC".equals(fillRole)) {
                if (!isOkPass(ri.getQcPass())) {
                    throw new BusinessException(422, "关键项[" + it.getName() + "]品管未通过");
                }
            }
        }
    }

    private boolean isOkPass(String pass) {
        // 兼容旧值 PASS/FAIL 与新值 YES/NO; NA 视为通过
        return "PASS".equals(pass) || "YES".equals(pass) || "NA".equals(pass);
    }

    private boolean isNgPass(String pass) {
        return "FAIL".equals(pass) || "NO".equals(pass);
    }

    private void upsertItems(QaFaRecord rec, List<QaFaItemValueDto> dtos, String userId, boolean prodSide) {
        if (CollectionUtils.isEmpty(dtos)) return;
        Date now = new Date();
        Integer round = rec.getCurrentRound() == null ? 1 : rec.getCurrentRound();

        for (QaFaItemValueDto d : dtos) {
            if (!StringUtils.hasText(d.getTemplateItemId())) continue;
            QaFaRecordItem existing = recordMapper.selectItemByKey(rec.getId(), d.getTemplateItemId(), round);
            if (existing == null) {
                // 兜底插入(理论上 createRecord 时已建好)
                QaFaTemplateItem ti = templateMapper.selectItemById(d.getTemplateItemId());
                if (ti == null) continue;
                QaFaRecordItem ri = new QaFaRecordItem();
                ri.setId(uuid());
                ri.setRecordId(rec.getId());
                ri.setTemplateItemId(d.getTemplateItemId());
                ri.setItemCode(ti.getCode());
                ri.setItemName(ti.getName());
                ri.setRoundNo(round);
                if (prodSide) {
                    ri.setProdValue(d.getValue());
                    ri.setProdPass(d.getPass());
                    ri.setProdUserId(userId);
                    ri.setProdTime(now);
                } else {
                    ri.setQcValue(d.getValue());
                    ri.setQcPass(d.getPass());
                    ri.setQcUserId(userId);
                    ri.setQcTime(now);
                }
                ri.setRemark(d.getRemark());
                recordMapper.insertItem(ri);
            } else {
                QaFaRecordItem upd = new QaFaRecordItem();
                upd.setId(existing.getId());
                if (prodSide) {
                    upd.setProdValue(nullToEmpty(d.getValue()));
                    upd.setProdPass(nullToEmpty(d.getPass()));
                    upd.setProdUserId(userId);
                    upd.setProdTime(now);
                } else {
                    upd.setQcValue(nullToEmpty(d.getValue()));
                    upd.setQcPass(nullToEmpty(d.getPass()));
                    upd.setQcUserId(userId);
                    upd.setQcTime(now);
                }
                if (d.getRemark() != null) upd.setRemark(d.getRemark());
                recordMapper.updateItemSelective(upd);
            }
        }
    }

    /** mybatis null 不更新, 用空串"覆盖"语义 */
    private String nullToEmpty(String s) { return s == null ? "" : s; }

    private String normalizeSampleUnit(String unit) {
        return "PCS".equalsIgnoreCase(unit) ? "PCS" : "PNL";
    }

    private void touchRecord(String id) {
        QaFaRecord upd = new QaFaRecord();
        upd.setId(id);
        upd.setUpdateTime(new Date());
        recordMapper.updateSelective(upd);
    }

    private void writeAudit(String recordId, String from, String to, String action,
                            String userId, String userName, String comment) {
        QaFaAuditLog log = new QaFaAuditLog();
        log.setId(uuid());
        log.setRecordId(recordId);
        log.setFromStatus(from);
        log.setToStatus(to);
        log.setAction(action);
        log.setOperatorId(userId);
        log.setOperatorName(userName);
        log.setCommentText(comment);
        log.setOpTime(new Date());
        auditLogMapper.insert(log);
    }

    private String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /** FA + yyyyMMdd + 4位每日流水 */
    private synchronized String genRecordNo() {
        String day = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String prefix = "FA" + day;
        Integer seq = recordMapper.nextDailyRecordSeq(prefix);
        if (seq == null) seq = 1;
        if (seq > 9999) {
            throw new BusinessException(409, "当天首件单号流水已超过9999");
        }
        return prefix + String.format("%04d", seq);
    }
}
