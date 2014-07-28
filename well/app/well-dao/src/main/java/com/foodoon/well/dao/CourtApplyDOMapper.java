package com.foodoon.well.dao;

import com.foodoon.well.dao.domain.CourtApplyDO;
import com.foodoon.well.dao.domain.CourtApplyDOCriteria;
import java.util.List;

public interface CourtApplyDOMapper {
    int countByExample(CourtApplyDOCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourtApplyDO record);

    int insertSelective(CourtApplyDO record);

    List<CourtApplyDO> selectByExample(CourtApplyDOCriteria example);

    CourtApplyDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourtApplyDO record);

    int updateByPrimaryKey(CourtApplyDO record);
}