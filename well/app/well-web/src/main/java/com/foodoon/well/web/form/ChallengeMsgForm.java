package com.foodoon.well.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.foodoon.well.dao.domain.ChallengeMsgDO;
import com.sun.istack.internal.NotNull;

public class ChallengeMsgForm {
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

    public ChallengeMsgDO toDO(){
       ChallengeMsgDO challengeMsgDO  = new ChallengeMsgDO();
            challengeMsgDO.setChallengeId(this.challengeId);
                challengeMsgDO.setMsg(this.msg);
                challengeMsgDO.setUserId(this.userId);
           return challengeMsgDO;
}

}
