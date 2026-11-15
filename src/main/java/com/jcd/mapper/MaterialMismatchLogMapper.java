package com.jcd.mapper;


import com.jcd.dto.materialcheck.MismatchLogDto;
import com.jcd.model.MaterialMismatchLog;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 物料扫描异常日志 Mapper 接口
 *
 * 假设您在Spring Boot主类上配置了 @MapperScan("com.example.materialcheck.mapper")
 * 或者在这里添加 @Mapper 注解
 */
@Mapper()
public interface MaterialMismatchLogMapper {

    /**
     * 插入一条异常日志
     *
     * @param log 日志实体对象
     * @return 影响的行数
     */
    int insert(MaterialMismatchLog log);

    /**
     * 根据条件分页查询异常日志
     *
     * @param params 查询参数 (包含
     * startDate - 可选, Date, 开始时间
     * endDate - 可选, Date, 结束时间
     * startRow - 必填, long, 分页开始行 (Oracle ROWNUM)
     * endRow - 必填, long, 分页结束行 (Oracle ROWNUM)
     * )
     * @return DTO 列表
     */
    List<MismatchLogDto> findLogs(Map<String, Object> params);

    /**
     * 根据条件统计异常日志总数
     *
     * @param params 查询参数 (包含
     * startDate - 可选, Date, 开始时间
     * endDate - 可选, Date, 结束时间
     * )
     * @return 总记录数
     */
    long countLogs(Map<String, Object> params);
}
