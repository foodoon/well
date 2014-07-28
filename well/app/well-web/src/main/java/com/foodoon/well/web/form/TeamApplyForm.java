package com.foodoon.well.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.foodoon.well.dao.domain.TeamApplyDO;
import com.sun.istack.internal.NotNull;

public class TeamApplyForm {
    @NotNull
    private Integer teamId;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer status;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public TeamApplyDO toDO() {
        TeamApplyDO teamApplyDO = new TeamApplyDO();
        teamApplyDO.setTeamId(this.teamId);
        teamApplyDO.setUserId(this.userId);
        teamApplyDO.setStatus(this.status);
        return teamApplyDO;
    }

}
