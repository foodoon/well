package com.foodoon.well.dao;

import com.foodoon.well.dao.domain.SessionDO;
import com.foodoon.well.dao.domain.SessionDOCriteria;
import java.util.List;

public interface SessionDOMapper {
    int countByExample(SessionDOCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(SessionDO record);

    int insertSelective(SessionDO record);

    List<SessionDO> selectByExampleWithBLOBs(SessionDOCriteria example);

    List<SessionDO> selectByExample(SessionDOCriteria example);

    SessionDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SessionDO record);

    int updateByPrimaryKeyWithBLOBs(SessionDO record);

    int updateByPrimaryKey(SessionDO record);
}