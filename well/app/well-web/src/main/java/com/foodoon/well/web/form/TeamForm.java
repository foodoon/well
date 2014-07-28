package com.foodoon.well.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.foodoon.well.dao.domain.TeamDO;
import com.sun.istack.internal.NotNull;

public class TeamForm {
            @NotEmpty(message = "{不能为空}")
         private String name;

            @NotEmpty(message = "{不能为空}")
         private String desc;

            @NotNull       private Integer canJoin;

       public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public Integer getCanJoin() {
        return canJoin;
    }
    public void setCanJoin(Integer canJoin) {
        this.canJoin = canJoin;
    }

    public TeamDO toDO(){
TeamDO teamDO  = new TeamDO();
            teamDO.setName(this.name);
                teamDO.setDesc(this.desc);
                teamDO.setCanJoin(this.canJoin);
        return teamDO;
    }

}
