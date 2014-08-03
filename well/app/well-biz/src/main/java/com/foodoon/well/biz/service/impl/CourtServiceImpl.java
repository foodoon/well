package com.foodoon.well.biz.service.impl;

import com.foodoon.well.biz.CourtBiz;
import com.foodoon.well.biz.SessionBiz;
import com.foodoon.well.biz.service.CourtService;
import com.foodoon.well.dao.UserDOMapper;
import com.foodoon.well.dao.domain.CourtDO;
import com.foodoon.well.util.AppRequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by foodoon on 2014/8/3.
 */
public class CourtServiceImpl implements CourtService{
    @Autowired
    private CourtBiz courtBiz;
    @Autowired
    private SessionBiz sessionBiz;
    @Autowired
    private UserDOMapper userDOMapper;

    public boolean create(@AppRequestParam("sid")String sid, CourtDO courtDO) {
        return false;
    }

    public boolean update(@AppRequestParam("sid")String sid, CourtDO courtDO) {
        return false;
    }

    public boolean delete(@AppRequestParam("sid")String sid, @AppRequestParam("id")int id) {
        return false;
    }

    public boolean apply(@AppRequestParam("sid")String sid,@AppRequestParam("courtId") int courtId, @AppRequestParam("applyTime")String applyTime) {
        return false;
    }

    public boolean cancelApply(@AppRequestParam("sid")String sid, @AppRequestParam("applyId")int applyId) {
        return false;
    }

    public boolean passApply(@AppRequestParam("sid")String sid, @AppRequestParam("applyId")int applyId) {
        return false;
    }

    public boolean rejectApply(@AppRequestParam("sid")String sid, @AppRequestParam("applyId")int applyId) {
        return false;
    }

    public List<CourtDO> queryReserveList(@AppRequestParam("sid")String sid) {
        return null;
    }

    public List<CourtDO> queryReserveListForReview(String sid) {
        return null;
    }
}
