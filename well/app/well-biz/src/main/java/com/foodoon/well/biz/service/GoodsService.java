package com.foodoon.well.biz.service;

import com.foodoon.well.dao.domain.GoodsDO;

import java.util.List;

/**
 * Created by foodoon on 2014/7/30.
 */
public interface GoodsService {

    public boolean create(String sid,GoodsDO goodsDO);

    public boolean update(String sid,GoodsDO goodsDO);

    public boolean delete(String sid,int id);

    public List<GoodsDO> queryListByCourtId(int courtId);

    public List<GoodsDO> queryListByBuyer(String sid);

    public List<GoodsDO> queryListBySeller(String sid);

    public boolean buy(String sid,int id);

    public boolean cancelBuy(String sid,int tradeId);
}
