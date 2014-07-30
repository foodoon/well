package com.foodoon.well.web.form;

import org.hibernate.validator.constraints.NotEmpty;

import com.foodoon.well.dao.domain.TeamDO;
import com.sun.istack.internal.NotNull;

public class TeamForm {
    @NotEmpty(message = "{不能为空}")
    private String name;

    @NotEmpty(message = "{不能为空}")
    private String teamDesc;

    @NotNull
    private Integer canJoin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamDesc() {
        return teamDesc;
    }

    public void setTeamDesc(String desc) {
        this.teamDesc = desc;
    }

    public Integer getCanJoin() {
        return canJoin;
    }

    public void setCanJoin(Integer canJoin) {
        this.canJoin = canJoin;
    }

    public TeamDO toDO() {
        TeamDO teamDO = new TeamDO();
        teamDO.setName(this.name);
        teamDO.setTeamDesc(this.teamDesc);
        teamDO.setCanJoin(this.canJoin);
        return teamDO;
    }

}
