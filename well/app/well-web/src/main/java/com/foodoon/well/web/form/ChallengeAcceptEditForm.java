package com.foodoon.well.web.form;

import com.foodoon.well.dao.domain.ChallengeAcceptDO;


public class ChallengeAcceptEditForm extends ChallengeAcceptForm{

private Integer id;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public ChallengeAcceptDO toDO(){
ChallengeAcceptDO challengeAcceptDO  =super.toDO();
challengeAcceptDO.setId(this.id);
return challengeAcceptDO;
}

public void initForm(ChallengeAcceptDO challengeAcceptDO){
if(challengeAcceptDO == null){
return ;
}
this.setChallengeId(challengeAcceptDO.getChallengeId());
this.setTeamId(challengeAcceptDO.getTeamId());
this.setGoalCount(challengeAcceptDO.getGoalCount());
this.setChallengeResult(challengeAcceptDO.getChallengeResult());
this.setAccept(challengeAcceptDO.getAccept());
}

}
