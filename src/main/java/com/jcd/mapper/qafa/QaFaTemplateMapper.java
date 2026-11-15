package com.jcd.mapper.qafa;

import com.jcd.model.qafa.QaFaTemplate;
import com.jcd.model.qafa.QaFaTemplateItem;
import com.jcd.model.qafa.QaFaTemplateSection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface QaFaTemplateMapper {

    /** 根据工序代码查 ACTIVE 模板; processCode 可为空表示全部 */
    List<QaFaTemplate> selectActiveTemplates(@Param("processCode") String processCode);

    /** 查询所有启用模板涉及的工序 (distinct processCode/processName), 用于前端动态渲染 */
    List<QaFaTemplate> selectActiveProcesses();

    QaFaTemplate selectById(@Param("id") String id);

    List<QaFaTemplateSection> selectSectionsByTemplateId(@Param("templateId") String templateId);

    List<QaFaTemplateItem> selectItemsByTemplateId(@Param("templateId") String templateId);

    QaFaTemplateItem selectItemById(@Param("id") String id);

    int disableActiveTemplatesByProcess(@Param("processCode") String processCode,
                                        @Param("updateBy") String updateBy,
                                        @Param("updateTime") Date updateTime);

    int insertTemplate(QaFaTemplate template);

    int insertSection(QaFaTemplateSection section);

    int insertItem(QaFaTemplateItem item);
}
