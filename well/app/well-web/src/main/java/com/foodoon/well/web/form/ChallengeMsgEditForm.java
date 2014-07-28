package com.foodoon.well.web.form;

import com.foodoon.well.dao.domain.ChallengeMsgDO;


public class ChallengeMsgEditForm extends ChallengeMsgForm{

private Integer id;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public ChallengeMsgDO toDO(){
ChallengeMsgDO challengeMsgDO  =super.toDO();
challengeMsgDO.setId(this.id);
return challengeMsgDO;
}

public void initForm(ChallengeMsgDO challengeMsgDO){
if(challengeMsgDO == null){
return ;
}
this.setChallengeId(challengeMsgDO.getChallengeId());
this.setMsg(challengeMsgDO.getMsg());
}

}
