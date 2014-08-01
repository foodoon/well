package com.foodoon.well.dao.domain;

import com.foodoon.gooda.gen.GenField;

import java.util.Date;

public class OrderDO {
    private Integer id;

    @GenField(cn="商品ID",order=1,inSearchForm = false,canNull = false)
    private Integer goodsId;

    @GenField(cn="用户ID",order=1,inSearchForm = false,canNull = false)
    private Integer userId;

    @GenField(cn="留言",order=1,inSearchForm = false,canNull = false)
    private String leaveMsg;

    @GenField(cn="配送时间",order=1,inSearchForm = false,canNull = false)
    private Date deliveryTime;

    private Integer isDeleted;

    private Date gmtModify;

    private Date gmtCreate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getLeaveMsg() {
        return leaveMsg;
    }

    public void setLeaveMsg(String leaveMsg) {
        this.leaveMsg = leaveMsg == null ? null : leaveMsg.trim();
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}