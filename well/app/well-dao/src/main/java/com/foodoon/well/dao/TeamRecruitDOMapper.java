package com.foodoon.well.dao;

import com.foodoon.well.dao.domain.TeamRecruitDO;
import com.foodoon.well.dao.domain.TeamRecruitDOCriteria;
import java.util.List;

public interface TeamRecruitDOMapper {
    int countByExample(TeamRecruitDOCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeamRecruitDO record);

    int insertSelective(TeamRecruitDO record);

    List<TeamRecruitDO> selectByExample(TeamRecruitDOCriteria example);

    TeamRecruitDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeamRecruitDO record);

    int updateByPrimaryKey(TeamRecruitDO record);
}