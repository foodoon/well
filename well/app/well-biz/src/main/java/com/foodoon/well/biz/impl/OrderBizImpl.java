package com.foodoon.well.biz.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.foodoon.well.biz.OrderBiz;
import com.foodoon.well.dao.OrderDOMapper;
import com.foodoon.well.dao.domain.OrderDO;
import com.foodoon.well.dao.domain.OrderDOCriteria;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public class OrderBizImpl implements OrderBiz{

    private final static Logger logger = LoggerFactory.getLogger(OrderBizImpl.class);

    @Autowired
    private OrderDOMapper orderDOMapper;

    public BizResult detail(int id) {
        BizResult bizResult = new BizResult();
        try{
            OrderDO orderDO = orderDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("orderDO", orderDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query Order error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            OrderDOCriteria orderDOCriteria = new OrderDOCriteria();
            orderDOCriteria.setStartRow(baseQuery.getStartRow());
            orderDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = orderDOMapper.countByExample(orderDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<OrderDO> orderDOList = orderDOMapper.selectByExample(orderDOCriteria);
            bizResult.data.put("orderDOList", orderDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view Order list error", e);
        }
            return bizResult;
     }

    public BizResult delete(int id) {
        BizResult bizResult = new BizResult();
        try {
            orderDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete order error", e);
        }
        return bizResult;
    }

    public BizResult create(OrderDO orderDO) {
        orderDO.setGmtModify(new Date());
        orderDO.setGmtCreate(new Date());
        orderDO.setIsDeleted(0);
        BizResult bizResult = new BizResult();
        try {
            int id = orderDOMapper.insert(orderDO);
            bizResult.data.put("id", id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create Order error", e);
        }
        return bizResult;
    }

    public BizResult update(OrderDO orderDO) {
        BizResult bizResult = new BizResult();
        try {
            int id = orderDOMapper.updateByPrimaryKeySelective(orderDO);
            bizResult.data.put("id", id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update Order error", e);
        }
        return bizResult;
    }

    }
