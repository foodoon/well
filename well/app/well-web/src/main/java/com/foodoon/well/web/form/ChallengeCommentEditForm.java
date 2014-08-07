package com.foodoon.well.web.form;

import com.foodoon.well.dao.domain.ChallengeCommentDO;


public class ChallengeCommentEditForm extends ChallengeCommentForm{

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChallengeCommentDO toDO(){
        ChallengeCommentDO challengeCommentDO  =super.toDO();
        challengeCommentDO.setId(this.id);
        return challengeCommentDO;
    }

    public void initForm(ChallengeCommentDO challengeCommentDO){
        if(challengeCommentDO == null){
        return ;
    }
    this.setChallengeId(challengeCommentDO.getChallengeId());
    this.setMsg(challengeCommentDO.getMsg());
    this.setUserId(challengeCommentDO.getUserId());
}

}
