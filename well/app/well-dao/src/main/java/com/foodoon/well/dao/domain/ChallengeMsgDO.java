package com.foodoon.well.dao.domain;

import com.foodoon.gooda.gen.GenField;

import java.util.Date;

public class ChallengeMsgDO {
    private Integer id;

    @GenField(cn="约战ID",order=1,inSearchForm = false,canNull = false)
    private Integer challengeId;

    @GenField(cn="评论内容",order=1,inSearchForm = false,canNull = false)
    private String msg;

    private Integer isDeleted;

    private Date gmtModify;

    private Date gmtCreate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Integer challengeId) {
        this.challengeId = challengeId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}