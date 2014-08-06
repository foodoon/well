package com.foodoon.well.biz.service.impl;

import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;
import com.foodoon.well.biz.SessionBiz;
import com.foodoon.well.biz.service.ChallengeService;
import com.foodoon.well.dao.ChallengeDOMapper;
import com.foodoon.well.dao.TeamDOMapper;
import com.foodoon.well.dao.UserDOMapper;
import com.foodoon.well.dao.domain.*;
import com.foodoon.well.util.BizResultHelper;
import com.foodoon.well.util.CommonResultCode;
import com.foodoon.well.util.DateHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by foodoon on 2014/8/5.
 */
public class ChallengeServiceImpl implements ChallengeService {

    private final static Logger log = LoggerFactory.getLogger(ChallengeServiceImpl.class);
    @Autowired
    private SessionBiz sessionBiz;
    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private ChallengeDOMapper challengeDOMapper;
    @Autowired
    private TeamDOMapper teamDOMapper;

    public BizResult create(String sid, ChallengeDO challengeDO) {
        if (!StringUtils.hasText(sid) || challengeDO == null || challengeDO.getCourtId() < 1
                || !StringUtils.hasText(challengeDO.getChallengeDesc())
                || challengeDO.getChallengeTime() == null) {
            return BizResultHelper.newResultCode(CommonResultCode.PARAM_MISS);
        }
        BizResult bizResult = sessionBiz.checkSession(sid);
        if (!bizResult.success) {
            return bizResult;
        }
        SessionDO sessionDO = (SessionDO) bizResult.data.get("sessionDO");
        UserDO userDO = userDOMapper.selectByPrimaryKey(sessionDO.getUserId());
        if (userDO == null) {
            return BizResultHelper.newResultCode(CommonResultCode.USER_NOT_EXIST);
        }
        TeamDOCriteria teamDOCriteria = new TeamDOCriteria();
        teamDOCriteria.createCriteria().andUserIdEqualTo(userDO.getId());
        List<TeamDO> teamDOs = teamDOMapper.selectByExample(teamDOCriteria);
        if (org.springframework.util.CollectionUtils.isEmpty(teamDOs)) {
            return BizResultHelper.newResultCode(CommonResultCode.CHALLENGE_MUST_BE_TEAMER);
        }
        if (teamDOs.size() > 1) {
            return BizResultHelper.newResultCode(CommonResultCode.TEAM_CREATE_ONLY_ONE);
        }
        //同一个场地同一个时间点是否发布过约战
        ChallengeDOCriteria challengeDOCriteria = new ChallengeDOCriteria();
        challengeDOCriteria.createCriteria().andCourtIdEqualTo(challengeDO.getCourtId())
                .andChallengeTimeBetween(DateHelper.getStartTime(challengeDO.getChallengeTime()), DateHelper.getEndTime(challengeDO.getChallengeTime()));
        List<ChallengeDO> challengeDOs = challengeDOMapper.selectByExample(challengeDOCriteria);
        if (!org.springframework.util.CollectionUtils.isEmpty(challengeDOs)) {
            return BizResultHelper.newResultCode(CommonResultCode.CHALLENGE_PUB_DUPLICATE);
        }
        challengeDO.setGmtCreate(new Date());
        challengeDO.setGmtModify(new Date());
        challengeDO.setIsDeleted(0);
        challengeDO.setTeamId(teamDOs.get(0).getId());
        try {
            challengeDOMapper.insert(challengeDO);
            return BizResultHelper.newSuccess();
        } catch (Exception e) {
            log.error("create challenge error", e);
        }
        return BizResultHelper.newCommonError();
    }

    public BizResult update(String sid, ChallengeDO challengeDO) {
        if (!StringUtils.hasText(sid) || challengeDO == null || challengeDO.getId() < 1 || challengeDO.getCourtId() < 1
                || !StringUtils.hasText(challengeDO.getChallengeDesc())
                || challengeDO.getChallengeTime() == null) {
            return BizResultHelper.newResultCode(CommonResultCode.PARAM_MISS);
        }
        BizResult bizResult = sessionBiz.checkSession(sid);
        if (!bizResult.success) {
            return bizResult;
        }
        SessionDO sessionDO = (SessionDO) bizResult.data.get("sessionDO");
        UserDO userDO = userDOMapper.selectByPrimaryKey(sessionDO.getUserId());
        if (userDO == null) {
            return BizResultHelper.newResultCode(CommonResultCode.USER_NOT_EXIST);
        }
        TeamDOCriteria teamDOCriteria = new TeamDOCriteria();
        teamDOCriteria.createCriteria().andUserIdEqualTo(userDO.getId());
        List<TeamDO> teamDOs = teamDOMapper.selectByExample(teamDOCriteria);
        if (org.springframework.util.CollectionUtils.isEmpty(teamDOs)) {
            return BizResultHelper.newResultCode(CommonResultCode.CHALLENGE_MUST_BE_TEAMER);
        }
        if (teamDOs.size() > 1) {
            return BizResultHelper.newResultCode(CommonResultCode.TEAM_CREATE_ONLY_ONE);
        }
        //查询约战信息是否是自己发布的
        ChallengeDO challengeDO1 = challengeDOMapper.selectByPrimaryKey(challengeDO.getId());
        if (challengeDO1 == null) {
            return BizResultHelper.newResultCode(CommonResultCode.CHALLENGE_NOT_EXIST);
        }
        if (challengeDO1.getTeamId() != teamDOs.get(0).getId()) {
            return BizResultHelper.newResultCode(CommonResultCode.PERSSION_ERROR);
        }

        try {
            int update = challengeDOMapper.updateByPrimaryKeySelective(challengeDO);
            return BizResultHelper.newSuccess();
        } catch (Exception e) {
            log.error("create challenge error", e);
        }
        return BizResultHelper.newCommonError();
    }

    public BizResult delete(String sid, int id) {
        if (!StringUtils.hasText(sid) || id < 1) {
            return BizResultHelper.newResultCode(CommonResultCode.PARAM_MISS);
        }
        BizResult bizResult = sessionBiz.checkSession(sid);
        if (!bizResult.success) {
            return bizResult;
        }
        SessionDO sessionDO = (SessionDO) bizResult.data.get("sessionDO");
        UserDO userDO = userDOMapper.selectByPrimaryKey(sessionDO.getUserId());
        if (userDO == null) {
            return BizResultHelper.newResultCode(CommonResultCode.USER_NOT_EXIST);
        }
        TeamDOCriteria teamDOCriteria = new TeamDOCriteria();
        teamDOCriteria.createCriteria().andUserIdEqualTo(userDO.getId());
        List<TeamDO> teamDOs = teamDOMapper.selectByExample(teamDOCriteria);
        if (org.springframework.util.CollectionUtils.isEmpty(teamDOs)) {
            return BizResultHelper.newResultCode(CommonResultCode.CHALLENGE_MUST_BE_TEAMER);
        }
        if (teamDOs.size() > 1) {
            return BizResultHelper.newResultCode(CommonResultCode.TEAM_CREATE_ONLY_ONE);
        }
        //查询约战信息是否是自己发布的
        ChallengeDO challengeDO1 = challengeDOMapper.selectByPrimaryKey(id);
        if (challengeDO1 == null) {
            return BizResultHelper.newResultCode(CommonResultCode.CHALLENGE_NOT_EXIST);
        }
        if (challengeDO1.getTeamId() != teamDOs.get(0).getId()) {
            return BizResultHelper.newResultCode(CommonResultCode.PERSSION_ERROR);
        }

        try {
            challengeDOMapper.deleteByPrimaryKey(id);
            return BizResultHelper.newSuccess();
        } catch (Exception e) {
            log.error("create challenge error", e);
        }
        return BizResultHelper.newCommonError();
    }

    public BizResult queryListForApply(String sid,int pageNo,int pageSize) {
        if (!StringUtils.hasText(sid)) {
            return BizResultHelper.newResultCode(CommonResultCode.PARAM_MISS);
        }
        BizResult bizResult = sessionBiz.checkSession(sid);
        if (!bizResult.success) {
            return bizResult;
        }
        SessionDO sessionDO = (SessionDO) bizResult.data.get("sessionDO");
        UserDO userDO = userDOMapper.selectByPrimaryKey(sessionDO.getUserId());
        if (userDO == null) {
            return BizResultHelper.newResultCode(CommonResultCode.USER_NOT_EXIST);
        }
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNo(pageNo);
        baseQuery.setPageSize(pageSize);
        //查找
        return null;
    }

    public BizResult queryList(String sid,int pageNo,int pageSize) {
        return null;
    }

    public BizResult comment(String sid, int challengeId, String msg) {
        return null;
    }

    public BizResult apply(String sid, int challengeId) {
        return null;
    }

    public BizResult cancelApply(String sid, int challengeId) {
        return null;
    }
}
