package com.foodoon.well.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.foodoon.well.biz.ChallengeCommentBiz;
import com.foodoon.well.dao.ChallengeCommentDOMapper;
import com.foodoon.well.dao.domain.ChallengeCommentDO;
import com.foodoon.well.dao.domain.ChallengeCommentDOCriteria;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public class ChallengeCommentBizImpl implements ChallengeCommentBiz{

    private final static Logger logger = LoggerFactory.getLogger(ChallengeCommentBizImpl.class);

    @Autowired
    private ChallengeCommentDOMapper challengeCommentDOMapper;

    public BizResult detail(int id) {
        BizResult bizResult = new BizResult();
        try{
            ChallengeCommentDO challengeCommentDO = challengeCommentDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("challengeCommentDO", challengeCommentDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query ChallengeComment error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            ChallengeCommentDOCriteria challengeCommentDOCriteria = new ChallengeCommentDOCriteria();
            challengeCommentDOCriteria.setStartRow(baseQuery.getStartRow());
            challengeCommentDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = challengeCommentDOMapper.countByExample(challengeCommentDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<ChallengeCommentDO> challengeCommentDOList = challengeCommentDOMapper.selectByExample(challengeCommentDOCriteria);
            bizResult.data.put("challengeCommentDOList", challengeCommentDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view ChallengeComment list error", e);
        }
            return bizResult;
     }

    public BizResult delete(int id) {
        BizResult bizResult = new BizResult();
        try {
            challengeCommentDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete challengeComment error", e);
        }
        return bizResult;
    }

    public BizResult create(ChallengeCommentDO challengeCommentDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = challengeCommentDOMapper.insert(challengeCommentDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create ChallengeComment error", e);
        }
        return bizResult;
    }

    public BizResult update(ChallengeCommentDO challengeCommentDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = challengeCommentDOMapper.updateByPrimaryKeySelective(challengeCommentDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update ChallengeComment error", e);
        }
        return bizResult;
    }

    }
