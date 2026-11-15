package com.jcd.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcd.dto.EquipmentTypeDto;
import com.jcd.dto.EquipmentTypeParamDto;
import com.jcd.dto.ParamMaintenanceDto;
import com.jcd.dto.ParamOverrideDto;
import com.jcd.mapper.EquipmentMapper;
import com.jcd.mapper.EquipmentTypeMapper;
import com.jcd.mapper.ParamOverrideMapper;
import com.jcd.model.Equipment;
import com.jcd.model.EquipmentTypeParam;
import com.jcd.exception.BusinessException;
import com.jcd.mapper.EquipmentTypeParamMapper;
import com.jcd.model.ParamOverride;
import com.jcd.service.EquipmentTypeParamService;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EquipmentTypeParamServiceImpl implements EquipmentTypeParamService {

    @Autowired
    private EquipmentTypeParamMapper paramMapper;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private EquipmentTypeMapper equipmentTypeMapper;
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private ParamOverrideMapper paramOverrideMapper;

    @Override
    public List<EquipmentTypeDto> findAll() {
        return equipmentTypeMapper.findAll().stream()
                .map(entity -> {
                    EquipmentTypeDto dto = new EquipmentTypeDto();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void deleteParam(String id) {
        paramMapper.delete(id);
    }

    @Override
    public EquipmentTypeParamDto updateParam(EquipmentTypeParamDto paramDto) {
        EquipmentTypeParam entity = dtoToEntity(paramDto);
        entity.setUpdateTime(new Date());

        paramMapper.update(entity);
        return paramDto;
    }

    @Override
    @Transactional
    public EquipmentTypeParamDto createParamV2(EquipmentTypeParamDto paramDto) {
        EquipmentTypeParam entity = convertToEntity(paramDto);

        // 【核心改造】自动生成 param_key
        if (!StringUtils.hasText(entity.getParamKey())) {
            String pinyinKey;
            try {
                // 使用pinyin4j将中文名转为拼音，例如 "温度" -> "wendu"
                pinyinKey = PinyinHelper.convertToPinyinString(entity.getParamName(), "", PinyinFormat.WITHOUT_TONE);

            } catch (PinyinException e) {
                // 如果转换失败，使用UUID作为兜底
                pinyinKey = "param_" + UUID.randomUUID().toString().substring(0, 8);
            }
            // 检查是否存在同名key，如果存在则添加后缀
            long count = paramMapper.countByKeyAndTypeId(pinyinKey, entity.getEqpTypeId());
            if(count > 0) {
                entity.setParamKey(pinyinKey + "_" + (count + 1));
            } else {
                entity.setParamKey(pinyinKey);
            }
        }

        entity.setId(UUID.randomUUID().toString().replace("-", ""));
        entity.setCreateTime(new Date());
        // 假设从安全上下文中获取当前用户，如果没有则为null
        // entity.setCreateBy(getCurrentUser());

        paramMapper.insert(entity);
        return convertToDto(entity);
    }

    @Override
    @Transactional
    public List<Equipment> searchEquipmentsByKeyword(String keyword) {
        List<Equipment> equipments = equipmentMapper.findByKeyword(keyword);
        return equipments.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<EquipmentTypeParamDto> findEnabledByEqpTypeId(String eqpTypeId) {
        return paramMapper.findEnabledByEqpTypeId(eqpTypeId).stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EquipmentTypeParamDto> findAllByEqpTypeId(String eqpTypeId) {
        return paramMapper.findAllByEqpTypeId(eqpTypeId).stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void create(EquipmentTypeParamDto dto) {
        EquipmentTypeParam entity = dtoToEntity(dto);
        entity.setId(UUID.randomUUID().toString().replace("-", ""));
        entity.setCreateTime(new Date());
         //entity.setCreateBy(dto.); // 从安全上下文中获取当前用户
        paramMapper.insert(entity);
    }

    @Override
    public void update(EquipmentTypeParamDto dto) {
        EquipmentTypeParam entity = dtoToEntity(dto);
        entity.setUpdateTime(new Date());
        // entity.setUpdateBy(currentUser);
        paramMapper.update(entity);
    }

    @Override
    public void delete(String paramId) {
        paramMapper.delete(paramId);
    }

    private EquipmentTypeParamDto entityToDto(EquipmentTypeParam entity) {
        EquipmentTypeParamDto dto = new EquipmentTypeParamDto();
        BeanUtils.copyProperties(entity, dto);
        try {
            // 将JSON字符串规则解析回对象，方便前端展示
            dto.setValidationRule(objectMapper.readTree(entity.getValidationRule().traverse()));
        } catch (Exception e) {
            // 解析失败则返回null
            dto.setValidationRule(null);
        }
        return dto;
    }

    @Override
    public ParamMaintenanceDto getEffectiveParamsForMaintenance(String eqpId) {
        ParamMaintenanceDto result = new ParamMaintenanceDto();
        List<ParamOverride> overrides = paramOverrideMapper.findByEqpId(eqpId);

        if (!CollectionUtils.isEmpty(overrides)) {
            result.setParamSource("OVERRIDE");
            result.setParameters(overrides.stream().map(this::convertToDto).collect(Collectors.toList()));
        } else {
            Equipment equipment = equipmentMapper.findById(eqpId);
            if (equipment == null ) {
                throw new BusinessException("设备不存在或未关联设备类型");
            }
            //String prefix = extractPrefixFromEqpCode(equipment);
            List<EquipmentTypeParam> defaults = paramMapper.findAllByEqpTypeId(equipment.getEqpTypeId());
            result.setParamSource("DEFAULT");
            result.setParameters(defaults.stream().map(this::convertFromDefaultToDto).collect(Collectors.toList()));
        }
        return result;
    }

    @Transactional
    @Override
    public List<ParamOverrideDto> createOverrideFromDefault(String eqpId) {
        if (!CollectionUtils.isEmpty(paramOverrideMapper.findByEqpId(eqpId))) {
            throw new BusinessException("该设备已存在独立参数，请勿重复创建");
        }
        Equipment equipment = equipmentMapper.findById(eqpId);

        if (equipment == null ) {
            throw new BusinessException("设备不存在或未关联设备类型，无法创建独立参数");
        }
        //String prefix = extractPrefixFromEqpCode(equipment);
        List<EquipmentTypeParam> defaults = paramMapper.findAllByEqpTypeId(equipment.getEqpTypeId());
        if (CollectionUtils.isEmpty(defaults)) {
            return Collections.emptyList(); // 如果默认参数为空，直接返回
        }

        List<ParamOverride> overrides = defaults.stream().map(def -> {
            ParamOverride override = new ParamOverride();
            BeanUtils.copyProperties(def, override);
            override.setId(UUID.randomUUID().toString().replace("-", ""));
            override.setEqpId(eqpId); // 关键：关联到具体设备
            override.setCreateTime(new Date());
            override.setParamKey(UUID.randomUUID().toString().replace("-", ""));
            return override;
        }).collect(Collectors.toList());


        try {
            paramOverrideMapper.batchInsert(overrides);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return overrides.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private String extractPrefixFromEqpCode(Equipment equipment) {
        String eqpCode = equipment.getEqpCode();
        String location = equipment.getLocation();
        if (eqpCode == null || eqpCode.isEmpty()) {
            return null;
        }
        int lastDashIndex = eqpCode.lastIndexOf('-');
        if (lastDashIndex > 0) {
            // 确保 '-' 不是最后一个字符
            if (lastDashIndex < eqpCode.length() - 1) {
                // 检查 '-' 后面的部分是否是纯数字 (可选，增加健壮性)
                String suffix = eqpCode.substring(lastDashIndex + 1);
                if (suffix.matches("\\d+")) { // 正则表达式 \d+ 匹配一个或多个数字
                    return eqpCode.substring(0, lastDashIndex + 1) +location; // 返回包含最后一个 '-' 的前缀
                }
            }
            // 如果规则不完全匹配 (例如 ALM-ZHT-A)，可以返回原始code或null，根据业务决定
            // return eqpCode;
        }
        // 如果没有 '-' 或不符合规则，可以返回 null 或原始 code
        return null;
    }

    @Transactional
    @Override
    public void revertToDefault(String eqpId) {
        paramOverrideMapper.deleteByEqpId(eqpId);
    }

    @Transactional
    @Override
    public ParamOverrideDto createOverrideParam(ParamOverrideDto dto) {
        ParamOverride entity = convertToEntity(dto);
        entity.setId(UUID.randomUUID().toString().replace("-", ""));
        entity.setCreateTime(new Date());
        paramOverrideMapper.insert(entity);
        return convertToDto(entity);
    }

    @Transactional
    @Override
    public ParamOverrideDto updateOverrideParam(ParamOverrideDto dto) {
        ParamOverride entity = paramOverrideMapper.findById(dto.getId());
        if (entity == null) {
            throw new BusinessException("参数不存在");
        }
        BeanUtils.copyProperties(dto, entity);
        entity.setUpdateTime(new Date());
        paramOverrideMapper.update(entity);
        return convertToDto(entity);
    }

    @Transactional
    @Override
    public void deleteOverrideParam(String id) {
        paramOverrideMapper.deleteById(id);
    }


    // 将前端传来的DTO转换为数据库实体
    private EquipmentTypeParam dtoToEntity(EquipmentTypeParamDto dto) {
        EquipmentTypeParam entity = new EquipmentTypeParam();
        BeanUtils.copyProperties(dto, entity, "validationRule");
        try {
            // 将对象规则序列化为JSON字符串以便存储
            entity.setValidationRule(dto.getValidationRule());
        } catch (Exception e) {
            throw new BusinessException("校验规则格式不正确");
        }
        return entity;
    }

    private Equipment convertToDto(Equipment entity) {
        Equipment dto = new Equipment();
        dto.setId(entity.getId());
        dto.setEqpCode(entity.getEqpCode());
        dto.setEqpName(entity.getEqpName());
        dto.setEqpTypeId(entity.getEqpTypeId());
        dto.setLocation(entity.getLocation());
        return dto;
    }

    private EquipmentTypeParam convertToEntity(EquipmentTypeParamDto dto) {
        if (dto == null) {
            return null;
        }
        EquipmentTypeParam entity = new EquipmentTypeParam();
        entity.setId(dto.getId());
        entity.setEqpTypeId(dto.getEqpTypeId());
        entity.setParamKey(dto.getParamKey());
        entity.setParamName(dto.getParamName());
        entity.setParamOrder(dto.getParamOrder());
        entity.setUnit(dto.getUnit());
        entity.setStandardDisplay(dto.getStandardDisplay());
        entity.setDataType(dto.getDataType());
        entity.setValidationType(dto.getValidationType());
        entity.setValidationRule(dto.getValidationRule());
        entity.setEnableFlag(dto.getEnableFlag());
        return entity;
    }

    private EquipmentTypeParamDto convertToDto(EquipmentTypeParam entity) {
        if (entity == null) {
            return null;
        }
        EquipmentTypeParamDto dto = new EquipmentTypeParamDto();
        dto.setId(entity.getId());
        dto.setEqpTypeId(entity.getEqpTypeId());
        dto.setParamKey(entity.getParamKey());
        dto.setParamName(entity.getParamName());
        dto.setParamOrder(entity.getParamOrder());
        dto.setUnit(entity.getUnit());
        dto.setStandardDisplay(entity.getStandardDisplay());
        dto.setDataType(entity.getDataType());
        dto.setValidationType(entity.getValidationType());
        dto.setValidationRule(entity.getValidationRule());
        dto.setEnableFlag(entity.getEnableFlag());
        return dto;
    }

    // --- 私有转换辅助方法 ---
    private ParamOverrideDto convertToDto(ParamOverride entity) {
        ParamOverrideDto dto = new ParamOverrideDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    private ParamOverride convertToEntity(ParamOverrideDto dto) {
        ParamOverride entity = new ParamOverride();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    private ParamOverrideDto convertFromDefaultToDto(EquipmentTypeParam defaultParam) {
        ParamOverrideDto dto = new ParamOverrideDto();
        BeanUtils.copyProperties(defaultParam, dto);
        // DTO中没有ID和eqpId，因为这是默认参数，尚未创建覆盖实例
        dto.setId(defaultParam.getId());
        dto.setEqpId(defaultParam.getEqpTypeId());
        return dto;
    }
}