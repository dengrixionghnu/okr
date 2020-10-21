package org.sean.okr.infrastructure.gatewayImpl.database.mapper;

import java.util.List;
import org.sean.okr.infrastructure.gatewayImpl.database.DO.Object;

public interface ObjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Object record);

    int insertSelective(Object record);


    Object selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Object record);

    int updateByPrimaryKey(Object record);
}