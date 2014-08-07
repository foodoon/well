package com.foodoon.well.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.foodoon.well.dao.domain.ChallengeCommentDO;
import javax.validation.constraints.NotNull;

public class ChallengeCommentForm {
                    @NotNull     private Integer challengeId;

                    @NotEmpty(message = "{不能为空}")
            private String msg;

                    @NotNull     private Integer userId;

    public Integer getChallengeId() {
       return challengeId;
    }

    public void setChallengeId(Integer challengeId) {
       this.challengeId = challengeId;
    }
    public String getMsg() {
       return msg;
    }

    public void setMsg(String msg) {
       this.msg = msg;
    }
    public Integer getUserId() {
       return userId;
    }

    public void setUserId(Integer userId) {
       this.userId = userId;
    }

    public ChallengeCommentDO toDO(){
       ChallengeCommentDO challengeCommentDO  = new ChallengeCommentDO();
            challengeCommentDO.setChallengeId(this.challengeId);
                challengeCommentDO.setMsg(this.msg);
                challengeCommentDO.setUserId(this.userId);
           return challengeCommentDO;
}

}
