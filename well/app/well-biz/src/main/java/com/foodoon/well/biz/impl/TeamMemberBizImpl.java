package com.foodoon.well.biz.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.foodoon.well.biz.TeamMemberBiz;
import com.foodoon.well.dao.TeamMemberDOMapper;
import com.foodoon.well.dao.domain.TeamMemberDO;
import com.foodoon.well.dao.domain.TeamMemberDOCriteria;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public class TeamMemberBizImpl implements TeamMemberBiz{

    private final static Logger logger = LoggerFactory.getLogger(TeamMemberBizImpl.class);

    @Autowired
    private TeamMemberDOMapper teamMemberDOMapper;

    public BizResult detail(int id) {
        BizResult bizResult = new BizResult();
        try{
            TeamMemberDO teamMemberDO = teamMemberDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("teamMemberDO", teamMemberDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query TeamMember error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            TeamMemberDOCriteria teamMemberDOCriteria = new TeamMemberDOCriteria();
            teamMemberDOCriteria.setStartRow(baseQuery.getStartRow());
            teamMemberDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = teamMemberDOMapper.countByExample(teamMemberDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<TeamMemberDO> teamMemberDOList = teamMemberDOMapper.selectByExample(teamMemberDOCriteria);
            bizResult.data.put("teamMemberDOList", teamMemberDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view TeamMember list error", e);
        }
            return bizResult;
     }

    public BizResult delete(int id) {
        BizResult bizResult = new BizResult();
        try {
            teamMemberDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete teamMember error", e);
        }
        return bizResult;
    }

    public BizResult create(TeamMemberDO teamMemberDO) {
        BizResult bizResult = new BizResult();
        try {
            int id = teamMemberDOMapper.insert(teamMemberDO);
            bizResult.data.put("id", id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create TeamMember error", e);
        }
        return bizResult;
    }

    public BizResult update(TeamMemberDO teamMemberDO) {
        BizResult bizResult = new BizResult();
        try {
            int id = teamMemberDOMapper.updateByPrimaryKeySelective(teamMemberDO);
            bizResult.data.put("id", id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update TeamMember error", e);
        }
        return bizResult;
    }

    }
