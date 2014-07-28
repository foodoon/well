package com.foodoon.well.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.foodoon.well.dao.domain.TeamRecruitDO;
import com.sun.istack.internal.NotNull;

public class TeamRecruitForm {
    @NotNull
    private Integer userId;

    @NotEmpty(message = "{不能为空}")
    private String desc;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public TeamRecruitDO toDO() {
        TeamRecruitDO teamRecruitDO = new TeamRecruitDO();
        teamRecruitDO.setUserId(this.userId);
        teamRecruitDO.setDesc(this.desc);
        return teamRecruitDO;
    }

}
