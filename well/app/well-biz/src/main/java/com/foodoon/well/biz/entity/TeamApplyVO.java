package com.foodoon.well.biz.entity;

import com.foodoon.well.dao.domain.TeamApplyDO;

/**
 * Created by foodoon on 2014/7/30.
 */
public class TeamApplyVO extends TeamApplyDO {


    private String applyUserName;


    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }
}
