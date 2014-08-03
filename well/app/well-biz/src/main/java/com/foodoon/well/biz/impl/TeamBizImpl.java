package com.foodoon.well.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.foodoon.well.biz.TeamBiz;
import com.foodoon.well.dao.TeamDOMapper;
import com.foodoon.well.dao.domain.TeamDO;
import com.foodoon.well.dao.domain.TeamDOCriteria;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public class TeamBizImpl implements TeamBiz{

    private final static Logger logger = LoggerFactory.getLogger(TeamBizImpl.class);

    @Autowired
    private TeamDOMapper teamDOMapper;

    public BizResult detail(int id) {
        BizResult bizResult = new BizResult();
        try{
            TeamDO teamDO = teamDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("teamDO", teamDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query Team error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            TeamDOCriteria teamDOCriteria = new TeamDOCriteria();
            teamDOCriteria.setStartRow(baseQuery.getStartRow());
            teamDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = teamDOMapper.countByExample(teamDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<TeamDO> teamDOList = teamDOMapper.selectByExample(teamDOCriteria);
            bizResult.data.put("teamDOList", teamDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view Team list error", e);
        }
            return bizResult;
     }

    public BizResult delete(int id) {
        BizResult bizResult = new BizResult();
        try {
            teamDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete team error", e);
        }
        return bizResult;
    }

    public BizResult create(TeamDO teamDO) {
        BizResult bizResult = new BizResult();
        try {
            int id = teamDOMapper.insert(teamDO);
            bizResult.data.put("id", id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create Team error", e);
        }
        return bizResult;
    }

    public BizResult update(TeamDO teamDO) {
        BizResult bizResult = new BizResult();
        try {
            int id = teamDOMapper.updateByPrimaryKeySelective(teamDO);
            bizResult.data.put("id", id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update Team error", e);
        }
        return bizResult;
    }

    }
