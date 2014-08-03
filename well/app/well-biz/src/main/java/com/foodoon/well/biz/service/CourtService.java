package com.foodoon.well.biz.service;

import com.foodoon.well.dao.domain.CourtDO;

import java.util.List;

/**
 * Created by foodoon on 2014/7/31.
 */
public interface CourtService {

    public boolean create(String sid,CourtDO courtDO);

    public boolean update(String sid,CourtDO courtDO);

    public boolean delete(String sid,int id);

    public boolean apply(String sid,int courtId,String applyTime);

    public boolean cancelApply(String sid,int applyId);

    public boolean passApply(String sid,int applyId);

    public List<CourtDO> queryReserveList(String sid);

    public List<CourtDO> queryReserveListForReview(String sid);

}
