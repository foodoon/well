package com.foodoon.well.biz.entity;

import com.foodoon.well.dao.domain.TeamDO;

/**
 * Created by foodoon on 2014/8/3.
 */
public class TeamMemberVO extends TeamDO {

    public TeamMemberVO(){

    }

    public TeamMemberVO(TeamDO teamDO){
        this.setIsDeleted(teamDO.getIsDeleted());
        this.setCanJoin(teamDO.getCanJoin());
        this.setUserId(teamDO.getUserId());
        this.setGmtModify(teamDO.getGmtModify());
        this.setGmtCreate(teamDO.getGmtCreate());
        this.setId(teamDO.getId());
        this.setName(teamDO.getName());
        this.setTeamDesc(teamDO.getTeamDesc());
    }

    private int memberUserId;

    private String memberUserName;

    private String memberUserRealName;


}
