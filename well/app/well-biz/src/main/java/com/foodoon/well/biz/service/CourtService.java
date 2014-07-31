package com.foodoon.well.biz.service;

import com.foodoon.well.dao.domain.CourtDO;

import java.util.List;

/**
 * Created by foodoon on 2014/7/31.
 */
public interface CourtService {

    public boolean create(CourtDO courtDO);

    public boolean update(CourtDO courtDO);

    public boolean delete(int id);

    public boolean apply(int userId,int courtId,String applyTime);

    public boolean cancelApply(int applyId);

    public boolean passApply(int applyId);

    public List<CourtDO> queryReserveList(int userId);

    public List<CourtDO> queryReserveListForReview(int userId);

}
