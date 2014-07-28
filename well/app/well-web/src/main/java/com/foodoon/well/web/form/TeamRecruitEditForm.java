package com.foodoon.well.web.form;

import com.foodoon.well.dao.domain.TeamRecruitDO;


public class TeamRecruitEditForm extends TeamRecruitForm{

private Integer id;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public TeamRecruitDO toDO(){
TeamRecruitDO teamRecruitDO  =super.toDO();
teamRecruitDO.setId(this.id);
return teamRecruitDO;
}

public void initForm(TeamRecruitDO teamRecruitDO){
if(teamRecruitDO == null){
return ;
}
this.setUserId(teamRecruitDO.getUserId());
this.setDesc(teamRecruitDO.getDesc());
}

}
