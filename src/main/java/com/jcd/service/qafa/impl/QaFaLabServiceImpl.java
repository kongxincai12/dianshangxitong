package com.jcd.service.qafa.impl;

import com.alibaba.fastjson.JSON;
import com.jcd.exception.BusinessException;
import com.jcd.mapper.qafa.QaFaLabDataMapper;
import com.jcd.mapper.qafa.QaFaRecordMapper;
import com.jcd.model.qafa.QaFaLabData;
import com.jcd.model.qafa.QaFaLabDataItem;
import com.jcd.model.qafa.QaFaRecord;
import com.jcd.service.qafa.LabExcelParserService;
import com.jcd.service.qafa.QaFaLabService;
import com.jcd.service.qafa.SmbBrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class QaFaLabServiceImpl implements QaFaLabService {

    @Autowired private SmbBrowseService smbBrowseService;
    @Autowired private LabExcelParserService labExcelParserService;
    @Autowired private QaFaLabDataMapper labDataMapper;
    @Autowired private QaFaRecordMapper recordMapper;

    @Override
    public String getRoot() {
        return smbBrowseService.getRoot();
    }

    @Override
    public Map<String, Object> browse(String relativePath) throws Exception {
        SmbBrowseService.BrowseResult br = smbBrowseService.list(relativePath);
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("root", smbBrowseService.getRoot());
        m.put("relativePath", br.getRelativePath());
        m.put("entries", br.getEntries());
        return m;
    }

    @Override
    @Transactional
    public Map<String, Object> parseAndSave(String relativePath, String recordId, String userId) throws Exception {
        if (!StringUtils.hasText(relativePath)) {
            throw new BusinessException(400, "relativePath 必填");
        }
        QaFaRecord rec = null;
        if (StringUtils.hasText(recordId)) {
            rec = recordMapper.selectById(recordId);
            if (rec == null) throw new BusinessException(404, "首件记录不存在");
        }
        String localPath = smbBrowseService.copyToTemp(relativePath);
        String fileName = Paths.get(relativePath).getFileName().toString();

        LabExcelParserService.ParseResult pr = labExcelParserService.parse(
                localPath, fileName, rec == null ? null : rec.getLotName());

        QaFaLabData header = pr.getHeader();
        header.setSourceType("SMB");
        header.setSmbFullPath(relativePath);
        header.setParsedTime(new Date());
        header.setParsedBy(userId);
        header.setParseStatus(pr.getParseStatus());
        header.setParseError(pr.getParseError());

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("data", header);
        result.put("items", pr.getItems());

        if (rec != null && !"FAILED".equals(pr.getParseStatus())) {
            // 落库
            header.setId(uuid());
            header.setRecordId(recordId);
            try {
                Map<String, Object> raw = new HashMap<>();
                raw.put("items", pr.getItems());
                header.setRawJson(JSON.toJSONString(raw));
            } catch (Exception ignore) {}
            labDataMapper.insert(header);
            if (pr.getItems() != null && !pr.getItems().isEmpty()) {
                for (QaFaLabDataItem it : pr.getItems()) {
                    it.setId(uuid());
                    it.setLabDataId(header.getId());
                }
                labDataMapper.batchInsertItems(pr.getItems());
            }
            result.put("saved", true);
            result.put("labDataId", header.getId());
        } else {
            result.put("saved", false);
        }

        // 删除临时文件
        try { Files.deleteIfExists(Paths.get(localPath)); } catch (Exception ignore) {}
        return result;
    }

    @Override
    public List<Map<String, Object>> listByRecord(String recordId) {
        List<QaFaLabData> list = labDataMapper.selectByRecordId(recordId);
        List<Map<String, Object>> out = new ArrayList<>();
        for (QaFaLabData d : list) {
            Map<String, Object> m = new LinkedHashMap<>();
            m.put("data", d);
            m.put("items", labDataMapper.selectItemsByLabDataId(d.getId()));
            out.add(m);
        }
        return out;
    }

    @Override
    @Transactional
    public void delete(String labDataId, String userId) {
        QaFaLabData d = labDataMapper.selectById(labDataId);
        if (d == null) throw new BusinessException(404, "记录不存在");
        labDataMapper.deleteItemsByLabDataId(labDataId);
        labDataMapper.deleteById(labDataId);
    }

    private String uuid() { return UUID.randomUUID().toString().replace("-", ""); }
}
