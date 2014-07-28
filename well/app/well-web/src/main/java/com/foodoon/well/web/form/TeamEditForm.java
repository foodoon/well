package com.foodoon.well.web.form;

import com.foodoon.well.dao.domain.TeamDO;


public class TeamEditForm extends TeamForm {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TeamDO toDO() {
        TeamDO teamDO = super.toDO();
        teamDO.setId(this.id);
        return teamDO;
    }

    public void initForm(TeamDO teamDO) {
        if (teamDO == null) {
            return;
        }
        this.setName(teamDO.getName());
        this.setDesc(teamDO.getDesc());
        this.setCanJoin(teamDO.getCanJoin());
    }

}
