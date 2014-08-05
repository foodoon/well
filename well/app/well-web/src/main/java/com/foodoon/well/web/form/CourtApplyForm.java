package com.foodoon.well.web.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.foodoon.well.dao.domain.CourtApplyDO;
import com.sun.istack.internal.NotNull;

public class CourtApplyForm {
                    @NotNull     private Integer userId;

                    @NotNull     private Integer courtId;

                    @NotNull     private Date bookingTime;

                    @NotNull     private Integer status;

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
    public Date getBookingTime() {
       return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
       this.bookingTime = bookingTime;
    }
    public Integer getStatus() {
       return status;
    }

    public void setStatus(Integer status) {
       this.status = status;
    }

    public CourtApplyDO toDO(){
       CourtApplyDO courtApplyDO  = new CourtApplyDO();
            courtApplyDO.setUserId(this.userId);
                courtApplyDO.setCourtId(this.courtId);
                courtApplyDO.setBookingTime(this.bookingTime);
                courtApplyDO.setStatus(this.status);
           return courtApplyDO;
}

}
