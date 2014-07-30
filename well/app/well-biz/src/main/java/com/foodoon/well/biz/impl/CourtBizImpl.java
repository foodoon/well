package com.foodoon.well.biz.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.foodoon.well.biz.CourtBiz;
import com.foodoon.well.dao.CourtDOMapper;
import com.foodoon.well.dao.domain.CourtDO;
import com.foodoon.well.dao.domain.CourtDOCriteria;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public class CourtBizImpl implements CourtBiz{

    private final static Logger logger = LoggerFactory.getLogger(CourtBizImpl.class);

    @Autowired
    private CourtDOMapper courtDOMapper;

    public BizResult detail(int id) {
        BizResult bizResult = new BizResult();
        try{
            CourtDO courtDO = courtDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("courtDO", courtDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query Court error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            CourtDOCriteria courtDOCriteria = new CourtDOCriteria();
            courtDOCriteria.setStartRow(baseQuery.getStartRow());
            courtDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = courtDOMapper.countByExample(courtDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<CourtDO> courtDOList = courtDOMapper.selectByExample(courtDOCriteria);
            bizResult.data.put("courtDOList", courtDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view Court list error", e);
        }
            return bizResult;
     }

    public BizResult delete(int id) {
        BizResult bizResult = new BizResult();
        try {
            courtDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete court error", e);
        }
        return bizResult;
    }

    public BizResult create(CourtDO courtDO) {
        BizResult bizResult = new BizResult();
        courtDO.setGmtModify(new Date());
        courtDO.setGmtCreate(new Date());
        courtDO.setIsDeleted(0);
        try {
            int id = courtDOMapper.insert(courtDO);
            bizResult.data.put("id", id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create Court error", e);
        }
        return bizResult;
    }

    public BizResult update(CourtDO courtDO) {
        BizResult bizResult = new BizResult();
        try {
            int id = courtDOMapper.updateByPrimaryKeySelective(courtDO);
            bizResult.data.put("id", id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update Court error", e);
        }
        return bizResult;
    }

    }
