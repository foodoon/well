package com.foodoon.well.dao;

import com.foodoon.well.dao.domain.GoodsDO;
import com.foodoon.well.dao.domain.GoodsDOCriteria;
import java.util.List;

public interface GoodsDOMapper {
    int countByExample(GoodsDOCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsDO record);

    int insertSelective(GoodsDO record);

    List<GoodsDO> selectByExample(GoodsDOCriteria example);

    GoodsDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsDO record);

    int updateByPrimaryKey(GoodsDO record);
}