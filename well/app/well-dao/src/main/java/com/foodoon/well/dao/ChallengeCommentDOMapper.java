package com.foodoon.well.dao;

import com.foodoon.well.dao.domain.ChallengeCommentDO;
import com.foodoon.well.dao.domain.ChallengeCommentDOCriteria;
import java.util.List;

public interface ChallengeCommentDOMapper {
    int countByExample(ChallengeCommentDOCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChallengeCommentDO record);

    int insertSelective(ChallengeCommentDO record);

    List<ChallengeCommentDO> selectByExample(ChallengeCommentDOCriteria example);

    ChallengeCommentDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChallengeCommentDO record);

    int updateByPrimaryKey(ChallengeCommentDO record);
}