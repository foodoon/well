package com.foodoon.well.biz.service;

import com.foodoon.tools.web.page.BizResult;
import com.foodoon.well.dao.domain.GoodsDO;

import java.util.List;

/**
 * Created by foodoon on 2014/7/30.
 */
public interface GoodsService {

    public BizResult create(String sid,GoodsDO goodsDO);

    public BizResult update(String sid,GoodsDO goodsDO);

    public BizResult delete(String sid,int id);

    public BizResult queryListByCourtId(int courtId,int pageNo,int pageSize);

    public BizResult queryOrderListByBuyer(String sid,int pageNo,int pageSize);

    public BizResult queryOrderListBySeller(String sid,int pageNo,int pageSize);

    public BizResult buy(String sid,int id);

    public BizResult cancelBuy(String sid,int tradeId);
}
