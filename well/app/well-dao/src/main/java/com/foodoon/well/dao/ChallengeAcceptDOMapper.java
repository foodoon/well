package com.foodoon.well.dao;

import com.foodoon.well.dao.domain.ChallengeAcceptDO;
import com.foodoon.well.dao.domain.ChallengeAcceptDOCriteria;
import java.util.List;

public interface ChallengeAcceptDOMapper {
    int countByExample(ChallengeAcceptDOCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChallengeAcceptDO record);

    int insertSelective(ChallengeAcceptDO record);

    List<ChallengeAcceptDO> selectByExample(ChallengeAcceptDOCriteria example);

    ChallengeAcceptDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChallengeAcceptDO record);

    int updateByPrimaryKey(ChallengeAcceptDO record);
}