package com.foodoon.well.web.form;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.foodoon.well.dao.domain.ChallengeAcceptDO;


public class ChallengeAcceptForm {
    @NotNull
    private Integer challengeId;

    @NotNull
    private Integer teamId;

    @NotNull
    private Integer goalCount;

    @NotEmpty(message = "{不能为空}")
    private String challengeResult;

    @NotNull
    private Integer accept;

    public Integer getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Integer challengeId) {
        this.challengeId = challengeId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getGoalCount() {
        return goalCount;
    }

    public void setGoalCount(Integer goalCount) {
        this.goalCount = goalCount;
    }

    public String getChallengeResult() {
        return challengeResult;
    }

    public void setChallengeResult(String challengeResult) {
        this.challengeResult = challengeResult;
    }

    public Integer getAccept() {
        return accept;
    }

    public void setAccept(Integer accept) {
        this.accept = accept;
    }

    public ChallengeAcceptDO toDO() {
        ChallengeAcceptDO challengeAcceptDO = new ChallengeAcceptDO();
        challengeAcceptDO.setChallengeId(this.challengeId);
        challengeAcceptDO.setTeamId(this.teamId);
        challengeAcceptDO.setGoalCount(this.goalCount);
        challengeAcceptDO.setChallengeResult(this.challengeResult);
        challengeAcceptDO.setAccept(this.accept);
        return challengeAcceptDO;
    }

}
