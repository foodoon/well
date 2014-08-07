package com.foodoon.well.web.form;

import com.foodoon.well.dao.domain.ChallengeApplyDO;


public class ChallengeApplyEditForm extends ChallengeApplyForm{

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChallengeApplyDO toDO(){
        ChallengeApplyDO challengeApplyDO  =super.toDO();
        challengeApplyDO.setId(this.id);
        return challengeApplyDO;
    }

    public void initForm(ChallengeApplyDO challengeApplyDO){
        if(challengeApplyDO == null){
        return ;
    }
    this.setChallengeId(challengeApplyDO.getChallengeId());
    this.setTeamId(challengeApplyDO.getTeamId());
    this.setGoalCount(challengeApplyDO.getGoalCount());
    this.setChallengeResult(challengeApplyDO.getChallengeResult());
    this.setAccept(challengeApplyDO.getAccept());
}

}
