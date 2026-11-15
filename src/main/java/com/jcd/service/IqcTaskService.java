package com.jcd.service;

import com.jcd.entity.IqcTaskInfo;

import java.util.List;
import java.util.Map;

public interface IqcTaskService {
    List<IqcTaskInfo> getTaskList(int startRow, int endRow,String poNumber,String partNumber, String keyword);
}
