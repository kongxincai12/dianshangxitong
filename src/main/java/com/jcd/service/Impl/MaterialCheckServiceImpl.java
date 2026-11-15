package com.jcd.service.Impl;
import com.jcd.dto.materialcheck.CheckRequest;
import com.jcd.dto.materialcheck.CheckResponse;
import com.jcd.dto.materialcheck.MismatchLogDto;
import com.jcd.dto.materialcheck.PagedLogResponse;
import com.jcd.mapper.MaterialMismatchLogMapper;
import com.jcd.mapper.PartnumberMapper;
import com.jcd.mapper.UpnMapper;
import com.jcd.model.MaterialMismatchLog;
import com.jcd.model.Upn;
import com.jcd.service.MaterialCheckService;
import com.jcd.service.PdaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

@Service
public class MaterialCheckServiceImpl implements MaterialCheckService {

    private static final Logger logger = LoggerFactory.getLogger(MaterialCheckServiceImpl.class);

    private final MaterialMismatchLogMapper logMapper;
    private final PdaService upnDataService; // 依赖您已有的UPN服务

    @Autowired
    @Resource
    private UpnMapper UpnMapper;

    @Autowired
    @Resource
    private PartnumberMapper partnumberMapper;

    @Autowired
    public MaterialCheckServiceImpl(MaterialMismatchLogMapper logMapper, PdaService upnDataService) {
        this.logMapper = logMapper;
        this.upnDataService = upnDataService;
    }

    /**
     * 执行物料一致性核对
     */
    @Override
    @Transactional // 确保日志记录和检查在同一事务中
    public CheckResponse checkConsistency(CheckRequest request) {
        if (request == null || !StringUtils.hasText(request.getUpn()) || !StringUtils.hasText(request.getSupplierMaterial())) {
            return CheckResponse.error("错误：供应商物料和UPN均不能为空！");
        }

        String upn = request.getUpn();
        String supplierMaterial = request.getSupplierMaterial();

        try {
            // 1. 调用您已有的UPN服务，根据UPN获取描述
            List<Upn> upns = UpnMapper.GetUpnByUpnname(upn);

            if (upns.size()<1) {
                return CheckResponse.error("错误：UPN [" + upn + "] 未在系统中找到！");
            }


            String fetchedDescription = partnumberMapper.selectByPrimaryKey(upns.get(0).getPnid()).getPartspec() ;

            // 2. 执行核心对比逻辑
            //    注意：这里的对比逻辑可能很复杂（例如截取字符串、部分匹配等）
            //    我们先使用 "包含" (contains) 作为示例逻辑。
            //    如果需要完全相等，请使用 fetchedDescription.equals(supplierMaterial)

            // ** 请根据您的实际业务修改此处的对比逻辑 **
            boolean isMatch = (fetchedDescription != null && fetchedDescription.contains(supplierMaterial));

            if (isMatch) {
                // 3. 一致
                return CheckResponse.success(fetchedDescription);
            } else {
                // 4. 不一致，记录异常日志
                logger.warn("物料不一致: 供应商 [{}], UPN [{}], 实际描述 [{}]", supplierMaterial, upn, fetchedDescription);
                logMismatch(supplierMaterial, upn, fetchedDescription, request.getOperator());

                return CheckResponse.mismatch(fetchedDescription, "警告：物料不一致，请核对！");
            }

        } catch (Exception e) {
            logger.error("核对物料时发生异常", e);
            return CheckResponse.error("系统异常：" + e.getMessage());
        }
    }

    /**
     * 内部方法：记录不一致日志
     */
    private void logMismatch(String supplierMaterial, String upn, String fetchedDescription, String operator) {
        MaterialMismatchLog log = new MaterialMismatchLog();
        log.setScannedSupplierMaterial(supplierMaterial);
        log.setScannedUpn(upn);
        log.setFetchedMaterialDescription(fetchedDescription);
        log.setOperatorUsername(operator);
        log.setLogTime(new Date()); // Mapper XML中的<selectKey>会覆盖ID，这里设置时间

        // 调用 MyBais Mapper 插入
        logMapper.insert(log);
    }


    /**
     * 分页查询异常日志
     */
    @Override
    public PagedLogResponse getMismatchLogs(int page, int size, Date startDate, Date endDate) {
        // 1. 准备查询参数
        Map<String, Object> params = new HashMap<>();

        // 处理Oracle的 DATE 类型查询边界
        if (startDate != null) {
            params.put("startDate", startDate);
        }
        if (endDate != null) {
            // 如果 endDate 是纯日期 (Y-m-d 00:00:00)，我们可能希望查询包含那一天
            // 例如：将其设置为当天的 23:59:59
            Calendar c = Calendar.getInstance();
            c.setTime(endDate);
            c.set(Calendar.HOUR_OF_DAY, 23);
            c.set(Calendar.MINUTE, 59);
            c.set(Calendar.SECOND, 59);
            params.put("endDate", c.getTime());
        }

        // 2. 统计总数
        long totalElements = logMapper.countLogs(params);
        if (totalElements == 0) {
            return new PagedLogResponse(0, 0, Collections.emptyList());
        }

        // 3. 计算分页 (MyBatis XML 中使用 ROWNUM)
        // Oracle ROWNUM 从 1 开始
        long startRow = (long) (page - 1) * size;
        long endRow = (long) page * size;
        params.put("startRow", startRow);
        params.put("endRow", endRow);

        // 4. 执行分页查询
        List<MismatchLogDto> logs = logMapper.findLogs(params);

        // 5. 组装结果
        long totalPages = (long) Math.ceil((double) totalElements / size);

        return new PagedLogResponse(totalPages, totalElements, logs);
    }
}

