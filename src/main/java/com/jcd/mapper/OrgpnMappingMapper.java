package com.jcd.mapper;

import org.apache.ibatis.annotations.Param;

public interface OrgpnMappingMapper {
    int countRelatedModels(@Param("modelA") String modelA, @Param("modelB") String modelB);
}
