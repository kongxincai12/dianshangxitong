package com.jcd.mapper;
import com.jcd.entity.IqcTaskInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;
@Mapper
public interface IqcTaskMapper {
    // 列表查询 (对应 TaskMapper.xml 中的 selectTaskList)
    // 这里为了方便前端展示，也可以直接返回 Map，或者返回 TaskInfo 实体
    List<IqcTaskInfo> selectTaskList(@Param("startRow") int startRow,
                                     @Param("endRow") int endRow,
                                     @Param("poNumber") String poNumber,
                                     @Param("partNumber") String partNumber,
                                     @Param("keyword") String keyword);

    // 根据ID查单条 (对应 TaskMapper.xml 中的 selectTaskById)
    IqcTaskInfo selectTaskById(@Param("id") String id);

    // 更新状态 (对应 TaskMapper.xml 中的 updateLegacyStatus)
    int updateLegacyStatus(@Param("id") String id);
}
