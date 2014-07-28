package com.foodoon.well.dao;

import com.foodoon.well.dao.domain.OrderDO;
import com.foodoon.well.dao.domain.OrderDOCriteria;
import java.util.List;

public interface OrderDOMapper {
    int countByExample(OrderDOCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderDO record);

    int insertSelective(OrderDO record);

    List<OrderDO> selectByExample(OrderDOCriteria example);

    OrderDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderDO record);

    int updateByPrimaryKey(OrderDO record);
}