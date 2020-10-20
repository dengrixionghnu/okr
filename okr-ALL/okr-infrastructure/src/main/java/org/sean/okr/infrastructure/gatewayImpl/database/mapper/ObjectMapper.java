package org.sean.okr.infrastructure.gatewayImpl.database.mapper;

import java.util.List;
import org.sean.okr.infrastructure.gatewayImpl.database.DO.Object;
import org.sean.okr.infrastructure.gatewayImpl.database.DO.ObjectExample;

public interface ObjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Object record);

    int insertSelective(Object record);

    List<Object> selectByExample(ObjectExample example);

    Object selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Object record);

    int updateByPrimaryKey(Object record);
}