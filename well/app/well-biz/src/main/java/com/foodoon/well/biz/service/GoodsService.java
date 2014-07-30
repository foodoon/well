package com.foodoon.well.biz.service;

import com.foodoon.well.dao.domain.GoodsDO;

import java.util.List;

/**
 * Created by foodoon on 2014/7/30.
 */
public interface GoodsService {

    public boolean create(GoodsDO goodsDO);

    public boolean update(GoodsDO goodsDO);

    public boolean delete(int id);

    public List<GoodsDO> queryListByCourtId(int courtId);

    public List<GoodsDO> queryListByBuyer(int userId);

    public List<GoodsDO> queryListBySeller(int userId);

    public boolean buy(int id);

    public boolean cancelBuy(int tradeId);
}
