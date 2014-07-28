package com.foodoon.well.dao;

import com.foodoon.well.dao.domain.TeamDO;
import com.foodoon.well.dao.domain.TeamDOCriteria;
import java.util.List;

public interface TeamDOMapper {
    int countByExample(TeamDOCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeamDO record);

    int insertSelective(TeamDO record);

    List<TeamDO> selectByExample(TeamDOCriteria example);

    TeamDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeamDO record);

    int updateByPrimaryKey(TeamDO record);
}