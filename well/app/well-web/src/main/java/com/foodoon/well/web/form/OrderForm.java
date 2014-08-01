package com.foodoon.well.web.form;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.foodoon.well.dao.domain.OrderDO;


public class OrderForm {
    @NotNull
    private Integer goodsId;

    @NotNull
    private Integer userId;

    @NotEmpty(message = "{不能为空}")
    private String leaveMsg;

    @NotNull
    private Date deliveryTime;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLeaveMsg() {
        return leaveMsg;
    }

    public void setLeaveMsg(String leaveMsg) {
        this.leaveMsg = leaveMsg;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public OrderDO toDO() {
        OrderDO orderDO = new OrderDO();
        orderDO.setGoodsId(this.goodsId);
        orderDO.setUserId(this.userId);
        orderDO.setLeaveMsg(this.leaveMsg);
        orderDO.setDeliveryTime(this.deliveryTime);
        return orderDO;
    }

}
