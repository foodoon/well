package com.foodoon.well.web.form;

import com.foodoon.well.dao.domain.CourtDO;


public class CourtEditForm extends CourtForm{

private Integer id;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public CourtDO toDO(){
CourtDO courtDO  =super.toDO();
courtDO.setId(this.id);
return courtDO;
}

public void initForm(CourtDO courtDO){
if(courtDO == null){
return ;
}
this.setName(courtDO.getName());
this.setAddress(courtDO.getAddress());
this.setType(courtDO.getType());
this.setOpenTime(courtDO.getOpenTime());
this.setUserId(courtDO.getUserId());
this.setStatus(courtDO.getStatus());
this.setDesc(courtDO.getDesc());
this.setSquare(courtDO.getSquare());
}

}
