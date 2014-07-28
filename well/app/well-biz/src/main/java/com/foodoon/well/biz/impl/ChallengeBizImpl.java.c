package com.foodoon.well.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.foodoon.well.biz.ChallengeBiz;
import com.foodoon.well.dao.ChallengeDOMapper;
import com.foodoon.well.dao.domain.ChallengeDO;
import com.foodoon.well.dao.domain.ChallengeDOCriteria;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public class ChallengeBizImpl implements ChallengeBiz{

    private final static Logger logger = LoggerFactory.getLogger(ChallengeBizImpl.class);

    @Autowired
    private ChallengeDOMapper challengeDOMapper;

    public BizResult detail(int id) {
        BizResult bizResult = new BizResult();
        try{
            ChallengeDO challengeDO = challengeDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("challengeDO", challengeDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query Challenge error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            ChallengeDOCriteria challengeDOCriteria = new ChallengeDOCriteria();
            challengeDOCriteria.setStartRow(baseQuery.getStartRow());
            challengeDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = challengeDOMapper.countByExample(challengeDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<ChallengeDO> challengeDOList = challengeDOMapper.selectByExample(challengeDOCriteria);
            bizResult.data.put("challengeDOList", challengeDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view Challenge list error", e);
        }
            return bizResult;
     }

    public BizResult delete(int id) {
        BizResult bizResult = new BizResult();
        try {
            challengeDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete challenge error", e);
        }
        return bizResult;
    }

    public BizResult create(ChallengeDO challengeDO) {
        BizResult bizResult = new BizResult();
        try {
            int id = challengeDOMapper.insert(challengeDO);
            bizResult.data.put("id", id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create Challenge error", e);
        }
        return bizResult;
    }

    public BizResult update(ChallengeDO challengeDO) {
        BizResult bizResult = new BizResult();
        try {
            int id = challengeDOMapper.updateByPrimaryKeySelective(challengeDO);
            bizResult.data.put("id", id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update Challenge error", e);
        }
        return bizResult;
    }

    }
