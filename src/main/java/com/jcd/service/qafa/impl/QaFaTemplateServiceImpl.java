package com.jcd.service.qafa.impl;

import com.jcd.dto.qafa.QaFaTemplateSaveDto;
import com.jcd.exception.BusinessException;
import com.jcd.mapper.qafa.QaFaTemplateMapper;
import com.jcd.model.qafa.QaFaTemplate;
import com.jcd.model.qafa.QaFaTemplateItem;
import com.jcd.model.qafa.QaFaTemplateSection;
import com.jcd.service.qafa.QaFaTemplateRuleUtil;
import com.jcd.service.qafa.QaFaTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class QaFaTemplateServiceImpl implements QaFaTemplateService {

    @Autowired
    private QaFaTemplateMapper templateMapper;

    @Override
    public List<QaFaTemplate> listActive(String processCode) {
        return templateMapper.selectActiveTemplates(processCode);
    }

    @Override
    public List<QaFaTemplate> listActiveProcesses() {
        return templateMapper.selectActiveProcesses();
    }

    @Override
    public Map<String, Object> getTemplateDetail(String templateId) {
        QaFaTemplate tpl = templateMapper.selectById(templateId);
        if (tpl == null) {
            throw new BusinessException(404, "模板不存在");
        }
        List<QaFaTemplateSection> sections = templateMapper.selectSectionsByTemplateId(templateId);
        List<QaFaTemplateItem> items = templateMapper.selectItemsByTemplateId(templateId);
        QaFaTemplateRuleUtil.applyRuleFields(items);

        Map<String, Object> result = new HashMap<>();
        result.put("template", tpl);
        result.put("sections", sections);
        result.put("items", items);
        return result;
    }

    @Override
    public QaFaTemplate getById(String id) {
        return templateMapper.selectById(id);
    }

    @Override
    public List<QaFaTemplateSection> getSections(String templateId) {
        return templateMapper.selectSectionsByTemplateId(templateId);
    }

    @Override
    public List<QaFaTemplateItem> getItems(String templateId) {
        List<QaFaTemplateItem> items = templateMapper.selectItemsByTemplateId(templateId);
        QaFaTemplateRuleUtil.applyRuleFields(items);
        return items;
    }

    @Override
    @Transactional
    public Map<String, Object> saveActiveVersion(QaFaTemplateSaveDto dto, String userId) {
        if (dto == null || dto.getTemplate() == null) {
            throw new BusinessException(400, "template必填");
        }
        QaFaTemplate input = dto.getTemplate();
        if (!StringUtils.hasText(input.getProcessCode())) {
            throw new BusinessException(400, "processCode必填");
        }
        if (!StringUtils.hasText(input.getProcessName())) {
            throw new BusinessException(400, "processName必填");
        }
        if (!StringUtils.hasText(input.getName())) {
            throw new BusinessException(400, "模板名称必填");
        }
        if (CollectionUtils.isEmpty(dto.getSections())) {
            throw new BusinessException(400, "至少维护一个检查分组");
        }
        if (CollectionUtils.isEmpty(dto.getItems())) {
            throw new BusinessException(400, "至少维护一个检查项");
        }
        validateStageConfiguration(dto.getSections());

        Date now = new Date();
        String templateId = uuid();
        templateMapper.disableActiveTemplatesByProcess(input.getProcessCode(), userId, now);
        templateMapper.insertTemplate(buildTemplate(input, templateId, userId, now));

        List<QaFaTemplateSection> savedSections = new ArrayList<>();
        Map<String, String> oldToNewSectionId = new HashMap<>();
        Map<String, String> codeToNewSectionId = new HashMap<>();
        for (QaFaTemplateSection section : dto.getSections()) {
            QaFaTemplateSection row = buildSection(section, templateId);
            oldToNewSectionId.put(section.getId(), row.getId());
            codeToNewSectionId.put(section.getCode(), row.getId());
            templateMapper.insertSection(row);
            savedSections.add(row);
        }

        Map<String, QaFaTemplateSection> oldSectionById = dto.getSections().stream()
                .filter(x -> x != null && x.getId() != null)
                .collect(Collectors.toMap(QaFaTemplateSection::getId, x -> x, (a, b) -> a, LinkedHashMap::new));

        int sortNo = 10;
        for (QaFaTemplateItem item : dto.getItems()) {
            QaFaTemplateItem row = buildItem(item, templateId, oldToNewSectionId, codeToNewSectionId,
                    oldSectionById, savedSections, sortNo);
            templateMapper.insertItem(row);
            sortNo += 10;
        }

        return getTemplateDetail(templateId);
    }

    private void validateStageConfiguration(List<QaFaTemplateSection> sections) {
        Set<String> finalStageCodes = new HashSet<>();
        Set<String> releaseStageCodes = new HashSet<>();
        int enabledSectionCount = 0;

        for (QaFaTemplateSection section : sections) {
            if (section == null || !isOn(section.getStageEnabled(), true)) continue;
            enabledSectionCount++;

            String stageCode = StringUtils.hasText(section.getStageCode())
                    ? section.getStageCode() : section.getCode();
            String stageName = StringUtils.hasText(section.getStageName())
                    ? section.getStageName() : section.getName();
            if (!StringUtils.hasText(stageCode) || !StringUtils.hasText(stageName)) {
                throw new BusinessException(400, "启用的检查分组必须选择审核阶段");
            }

            boolean finalRequired = isOn(section.getFinalRequired(), true);
            boolean releaseOnPass = isOn(section.getReleaseOnPass(), false);
            if (finalRequired) finalStageCodes.add(stageCode);
            if (releaseOnPass) {
                if (!finalRequired) {
                    throw new BusinessException(400, "放行阶段必须参与最终判定: " + stageName);
                }
                releaseStageCodes.add(stageCode);
            }
        }

        if (enabledSectionCount == 0) {
            throw new BusinessException(400, "至少启用一个审核阶段");
        }
        if (finalStageCodes.isEmpty()) {
            throw new BusinessException(400, "至少有一个阶段参与最终判定");
        }
        if (releaseStageCodes.size() != 1) {
            throw new BusinessException(400, "必须且只能配置一个通过后允许生产放行的阶段");
        }
    }

    private boolean isOn(Integer value, boolean defaultValue) {
        return value == null ? defaultValue : value == 1;
    }

    private QaFaTemplate buildTemplate(QaFaTemplate input, String templateId, String userId, Date now) {
        QaFaTemplate tpl = new QaFaTemplate();
        tpl.setId(templateId);
        tpl.setProcessCode(input.getProcessCode());
        tpl.setProcessName(input.getProcessName());
        tpl.setVersion(StringUtils.hasText(input.getVersion()) ? input.getVersion() : defaultVersion(now));
        tpl.setName(input.getName());
        tpl.setSopRef(input.getSopRef());
        tpl.setStatus("ACTIVE");
        tpl.setValidFrom(input.getValidFrom());
        tpl.setValidTo(input.getValidTo());
        tpl.setRemark(input.getRemark());
        tpl.setCreateBy(userId);
        tpl.setCreateTime(now);
        tpl.setUpdateBy(userId);
        tpl.setUpdateTime(now);
        return tpl;
    }

    private QaFaTemplateSection buildSection(QaFaTemplateSection input, String templateId) {
        if (input == null || !StringUtils.hasText(input.getCode()) || !StringUtils.hasText(input.getName())) {
            throw new BusinessException(400, "检查分组名称或系统编码缺失");
        }
        QaFaTemplateSection row = new QaFaTemplateSection();
        row.setId(uuid());
        row.setTemplateId(templateId);
        row.setCode(input.getCode());
        row.setName(input.getName());
        row.setSortNo(input.getSortNo());
        row.setRemark(input.getRemark());
        int stageEnabled = input.getStageEnabled() == null ? 1 : input.getStageEnabled();
        row.setStageCode(StringUtils.hasText(input.getStageCode())
                ? input.getStageCode() : (stageEnabled == 1 ? input.getCode() : null));
        row.setStageName(StringUtils.hasText(input.getStageName())
                ? input.getStageName() : (stageEnabled == 1 ? input.getName() : null));
        row.setStageSortNo(input.getStageSortNo() == null ? input.getSortNo() : input.getStageSortNo());
        row.setStageEnabled(stageEnabled);
        row.setFinalRequired(input.getFinalRequired() == null ? 1 : input.getFinalRequired());
        row.setReleaseOnPass(input.getReleaseOnPass() == null ? 0 : input.getReleaseOnPass());
        return row;
    }

    private QaFaTemplateItem buildItem(QaFaTemplateItem input,
                                       String templateId,
                                       Map<String, String> oldToNewSectionId,
                                       Map<String, String> codeToNewSectionId,
                                       Map<String, QaFaTemplateSection> oldSectionById,
                                       List<QaFaTemplateSection> savedSections,
                                       int defaultSortNo) {
        if (input == null || !StringUtils.hasText(input.getName())) {
            throw new BusinessException(400, "检查项名称必填");
        }
        String sectionId = oldToNewSectionId.get(input.getSectionId());
        if (!StringUtils.hasText(sectionId)) {
            QaFaTemplateSection oldSection = oldSectionById.get(input.getSectionId());
            if (oldSection != null) {
                sectionId = codeToNewSectionId.get(oldSection.getCode());
            }
        }
        if (!StringUtils.hasText(sectionId) && savedSections.size() == 1) {
            sectionId = savedSections.get(0).getId();
        }
        if (!StringUtils.hasText(sectionId)) {
            throw new BusinessException(400, "检查项目[" + input.getName() + "]未匹配到检查分组");
        }

        QaFaTemplateItem row = new QaFaTemplateItem();
        row.setId(uuid());
        row.setTemplateId(templateId);
        row.setSectionId(sectionId);
        row.setCode(StringUtils.hasText(input.getCode()) ? input.getCode() : ("ITEM_" + defaultSortNo));
        row.setName(input.getName());
        row.setTool(input.getTool());
        row.setStandardText(input.getStandardText());
        row.setInputType(StringUtils.hasText(input.getInputType()) ? input.getInputType() : "TEXT");
        row.setUnit(input.getUnit());
        row.setRuleJson(QaFaTemplateRuleUtil.mergeRangeRuleJson(input));
        row.setFillRole(StringUtils.hasText(input.getFillRole()) ? input.getFillRole() : "BOTH");
        row.setRequired(input.getRequired() == null ? 0 : input.getRequired());
        row.setCritical(input.getCritical() == null ? 0 : input.getCritical());
        row.setSortNo(input.getSortNo() == null ? defaultSortNo : input.getSortNo());
        row.setRemark(input.getRemark());
        return row;
    }

    private String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private String defaultVersion(Date now) {
        return "v" + new SimpleDateFormat("yyyyMMddHHmmss").format(now);
    }
}
