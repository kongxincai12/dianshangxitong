package com.jcd.service.qafa;

import com.jcd.dto.qafa.QaFaTemplateSaveDto;
import com.jcd.model.qafa.QaFaTemplate;
import com.jcd.model.qafa.QaFaTemplateItem;
import com.jcd.model.qafa.QaFaTemplateSection;

import java.util.List;
import java.util.Map;

public interface QaFaTemplateService {

    List<QaFaTemplate> listActive(String processCode);

    /** 启用模板涉及的所有工序 (用于前端动态渲染创建按钮 / 筛选) */
    List<QaFaTemplate> listActiveProcesses();

    /**
     * @return Map: template / sections / items
     */
    Map<String, Object> getTemplateDetail(String templateId);

    QaFaTemplate getById(String id);

    List<QaFaTemplateSection> getSections(String templateId);

    List<QaFaTemplateItem> getItems(String templateId);

    Map<String, Object> saveActiveVersion(QaFaTemplateSaveDto dto, String userId);
}
