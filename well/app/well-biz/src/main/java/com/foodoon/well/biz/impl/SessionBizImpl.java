package com.foodoon.well.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.foodoon.well.biz.SessionBiz;
import com.foodoon.well.dao.SessionDOMapper;
import com.foodoon.well.dao.domain.SessionDO;
import com.foodoon.well.dao.domain.SessionDOCriteria;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public class SessionBizImpl implements SessionBiz{

    private final static Logger logger = LoggerFactory.getLogger(SessionBizImpl.class);

    @Autowired
    private SessionDOMapper sessionDOMapper;

    public BizResult detail(int id) {
        BizResult bizResult = new BizResult();
        try{
            SessionDO sessionDO = sessionDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("sessionDO", sessionDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query Session error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            SessionDOCriteria sessionDOCriteria = new SessionDOCriteria();
            sessionDOCriteria.setStartRow(baseQuery.getStartRow());
            sessionDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = sessionDOMapper.countByExample(sessionDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<SessionDO> sessionDOList = sessionDOMapper.selectByExample(sessionDOCriteria);
            bizResult.data.put("sessionDOList", sessionDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view Session list error", e);
        }
            return bizResult;
     }

    public BizResult delete(int id) {
        BizResult bizResult = new BizResult();
        try {
            sessionDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete session error", e);
        }
        return bizResult;
    }

    public BizResult create(SessionDO sessionDO) {
        BizResult bizResult = new BizResult();
        try {
            int id = sessionDOMapper.insert(sessionDO);
            bizResult.data.put("id", id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create Session error", e);
        }
        return bizResult;
    }

    public BizResult update(SessionDO sessionDO) {
        BizResult bizResult = new BizResult();
        try {
            int id = sessionDOMapper.updateByPrimaryKeySelective(sessionDO);
            bizResult.data.put("id", id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update Session error", e);
        }
        return bizResult;
    }

    public SessionDO querySessionBySID(String sid) {
        try {
            SessionDOCriteria sessionDOCriteria = new SessionDOCriteria();
            sessionDOCriteria.setStartRow(0);
            sessionDOCriteria.setPageSize(2);
            SessionDOCriteria.Criteria criteria = sessionDOCriteria.createCriteria();
            criteria.andSIdEqualTo(sid);
            List<SessionDO> sessionDOList = sessionDOMapper.selectByExample(sessionDOCriteria);
            if(sessionDOList.size()>1){
                throw new RuntimeException("数据库记录多于一条:"+sid);
            }else if(sessionDOList.size() == 1){
                return sessionDOList.get(0);
            }
            return null;
        } catch (Exception e) {
            logger.error("view Session list error", e);
        }
        return null;
    }

}
