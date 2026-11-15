package com.jcd.service.Impl;
import com.jcd.entity.IqcTaskInfo;
import com.jcd.mapper.IqcTaskMapper;
import com.jcd.service.IqcTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class IqcTaskServiceImpl implements IqcTaskService {
    @Autowired
    private IqcTaskMapper taskMapper;

    /**
     * 获取任务列表
     * @param startRow 起始行
     * @param endRow 结束行
     * @param keyword 搜索关键字
     */
    @Override
    public List<IqcTaskInfo> getTaskList(int startRow, int endRow,String poNumber,String partNumber, String keyword) {
        return taskMapper.selectTaskList(startRow, endRow,poNumber,partNumber,keyword);
    }
}
