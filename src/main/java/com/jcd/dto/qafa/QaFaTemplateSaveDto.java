package com.jcd.dto.qafa;

import com.jcd.model.qafa.QaFaTemplate;
import com.jcd.model.qafa.QaFaTemplateItem;
import com.jcd.model.qafa.QaFaTemplateSection;
import lombok.Data;

import java.util.List;

@Data
public class QaFaTemplateSaveDto {
    private QaFaTemplate template;
    private List<QaFaTemplateSection> sections;
    private List<QaFaTemplateItem> items;
}
