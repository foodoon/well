package com.foodoon.well.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.foodoon.well.dao.domain.ChallengeDO;
import com.sun.istack.internal.NotNull;

public class ChallengeForm {
            @NotNull       private Integer userId;

            @NotNull       private Integer courtId;

            @NotNull       private Date challengeTime;

            @NotEmpty(message = "{不能为空}")
         private String challengeDesc;

            @NotEmpty(message = "{不能为空}")
         private String challengeResult;

            @NotNull       private Integer goalCount;

       public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getCourtId() {
        return courtId;
    }
    public void setCourtId(Integer courtId) {
        this.courtId = courtId;
    }
    public Date getChallengeTime() {
        return challengeTime;
    }
    public void setChallengeTime(Date challengeTime) {
        this.challengeTime = challengeTime;
    }
    public String getChallengeDesc() {
        return challengeDesc;
    }
    public void setChallengeDesc(String challengeDesc) {
        this.challengeDesc = challengeDesc;
    }
    public String getChallengeResult() {
        return challengeResult;
    }
    public void setChallengeResult(String challengeResult) {
        this.challengeResult = challengeResult;
    }
    public Integer getGoalCount() {
        return goalCount;
    }
    public void setGoalCount(Integer goalCount) {
        this.goalCount = goalCount;
    }

    public ChallengeDO toDO(){
ChallengeDO challengeDO  = new ChallengeDO();
            challengeDO.setUserId(this.userId);
                challengeDO.setCourtId(this.courtId);
                challengeDO.setChallengeTime(this.challengeTime);
                challengeDO.setChallengeDesc(this.challengeDesc);
                challengeDO.setChallengeResult(this.challengeResult);
                challengeDO.setGoalCount(this.goalCount);
        return challengeDO;
    }

}
