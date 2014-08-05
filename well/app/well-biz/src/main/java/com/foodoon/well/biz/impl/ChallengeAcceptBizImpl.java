package com.foodoon.well.biz.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.foodoon.well.biz.ChallengeAcceptBiz;
import com.foodoon.well.dao.ChallengeAcceptDOMapper;
import com.foodoon.well.dao.domain.ChallengeAcceptDO;
import com.foodoon.well.dao.domain.ChallengeAcceptDOCriteria;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public class ChallengeAcceptBizImpl implements ChallengeAcceptBiz{

    private final static Logger logger = LoggerFactory.getLogger(ChallengeAcceptBizImpl.class);

    @Autowired
    private ChallengeAcceptDOMapper challengeAcceptDOMapper;

    public BizResult detail(int id) {
        BizResult bizResult = new BizResult();
        try{
            ChallengeAcceptDO challengeAcceptDO = challengeAcceptDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("challengeAcceptDO", challengeAcceptDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query ChallengeAccept error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            ChallengeAcceptDOCriteria challengeAcceptDOCriteria = new ChallengeAcceptDOCriteria();
            challengeAcceptDOCriteria.setStartRow(baseQuery.getStartRow());
            challengeAcceptDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = challengeAcceptDOMapper.countByExample(challengeAcceptDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<ChallengeAcceptDO> challengeAcceptDOList = challengeAcceptDOMapper.selectByExample(challengeAcceptDOCriteria);
            bizResult.data.put("challengeAcceptDOList", challengeAcceptDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view ChallengeAccept list error", e);
        }
            return bizResult;
     }

    public BizResult delete(int id) {
        BizResult bizResult = new BizResult();
        try {
            challengeAcceptDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete challengeAccept error", e);
        }
        return bizResult;
    }

    public BizResult create(ChallengeAcceptDO challengeAcceptDO) {
        BizResult bizResult = new BizResult();
        challengeAcceptDO.setGmtModify(new Date());
        challengeAcceptDO.setGmtCreate(new Date());
        challengeAcceptDO.setIsDeleted(0);
        try {
            int id = challengeAcceptDOMapper.insert(challengeAcceptDO);
            bizResult.data.put("count", id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create ChallengeAccept error", e);
        }
        return bizResult;
    }

    public BizResult update(ChallengeAcceptDO challengeAcceptDO) {
        BizResult bizResult = new BizResult();
        try {
            int id = challengeAcceptDOMapper.updateByPrimaryKeySelective(challengeAcceptDO);
            bizResult.data.put("count", id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update ChallengeAccept error", e);
        }
        return bizResult;
    }

    }
