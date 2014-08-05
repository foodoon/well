package com.foodoon.well.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.foodoon.well.biz.ChallengeMsgBiz;
import com.foodoon.well.dao.ChallengeMsgDOMapper;
import com.foodoon.well.dao.domain.ChallengeMsgDO;
import com.foodoon.well.dao.domain.ChallengeMsgDOCriteria;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public class ChallengeMsgBizImpl implements ChallengeMsgBiz{

    private final static Logger logger = LoggerFactory.getLogger(ChallengeMsgBizImpl.class);

    @Autowired
    private ChallengeMsgDOMapper challengeMsgDOMapper;

    public BizResult detail(int id) {
        BizResult bizResult = new BizResult();
        try{
            ChallengeMsgDO challengeMsgDO = challengeMsgDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("challengeMsgDO", challengeMsgDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query ChallengeMsg error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            ChallengeMsgDOCriteria challengeMsgDOCriteria = new ChallengeMsgDOCriteria();
            challengeMsgDOCriteria.setStartRow(baseQuery.getStartRow());
            challengeMsgDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = challengeMsgDOMapper.countByExample(challengeMsgDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<ChallengeMsgDO> challengeMsgDOList = challengeMsgDOMapper.selectByExample(challengeMsgDOCriteria);
            bizResult.data.put("challengeMsgDOList", challengeMsgDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view ChallengeMsg list error", e);
        }
            return bizResult;
     }

    public BizResult delete(int id) {
        BizResult bizResult = new BizResult();
        try {
            challengeMsgDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete challengeMsg error", e);
        }
        return bizResult;
    }

    public BizResult create(ChallengeMsgDO challengeMsgDO) {
        BizResult bizResult = new BizResult();
        try {
            int id = challengeMsgDOMapper.insert(challengeMsgDO);
            bizResult.data.put("count", id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create ChallengeMsg error", e);
        }
        return bizResult;
    }

    public BizResult update(ChallengeMsgDO challengeMsgDO) {
        BizResult bizResult = new BizResult();
        try {
            int id = challengeMsgDOMapper.updateByPrimaryKeySelective(challengeMsgDO);
            bizResult.data.put("count", id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update ChallengeMsg error", e);
        }
        return bizResult;
    }

    }
