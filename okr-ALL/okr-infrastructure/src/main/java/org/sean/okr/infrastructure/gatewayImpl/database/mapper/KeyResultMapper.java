package org.sean.okr.infrastructure.gatewayImpl.database.mapper;

import java.util.List;
import org.sean.okr.infrastructure.gatewayImpl.database.DO.KeyResult;
import org.sean.okr.infrastructure.gatewayImpl.database.DO.KeyResultExample;

public interface KeyResultMapper {
    int deleteByPrimaryKey(Long id);

    int insert(KeyResult record);

    int insertSelective(KeyResult record);

    List<KeyResult> selectByExample(KeyResultExample example);

    KeyResult selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(KeyResult record);

    int updateByPrimaryKey(KeyResult record);
}