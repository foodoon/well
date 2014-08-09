package com.foodoon.well.biz.service.impl;

import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;
import com.foodoon.well.biz.SessionBiz;
import com.foodoon.well.biz.service.GoodsService;
import com.foodoon.well.dao.CourtDOMapper;
import com.foodoon.well.dao.GoodsDOMapper;
import com.foodoon.well.dao.OrderDOMapper;
import com.foodoon.well.dao.UserDOMapper;
import com.foodoon.well.dao.domain.*;
import com.foodoon.well.util.BizResultHelper;
import com.foodoon.well.util.CommonResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by well on 2014/8/9.
 */
public class GoodsServiceImpl implements GoodsService{
    private final static Logger log = LoggerFactory.getLogger(GoodsServiceImpl.class);
    @Autowired
    private GoodsDOMapper goodsDOMapper;
    @Autowired
    private CourtDOMapper courtDOMapper;
    @Autowired
    private SessionBiz sessionBiz;
    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private OrderDOMapper orderDOMapper;


    public BizResult create(String sid, GoodsDO goodsDO) {
        if (!StringUtils.hasText(sid) || goodsDO == null || goodsDO.getCourtId()<1
                || !StringUtils.hasText(goodsDO.getGoodsName())
                || goodsDO.getPrice()<1) {
            return BizResultHelper.newResultCode(CommonResultCode.PARAM_MISS);
        }
        BizResult bizResult = sessionBiz.checkSession(sid);
        if (!bizResult.success) {
            return bizResult;
        }
        SessionDO sessionDO = (SessionDO) bizResult.data.get("sessionDO");
        UserDO userDO = userDOMapper.selectByPrimaryKey(sessionDO.getUserId());
        if (userDO == null) {
            return BizResultHelper.newResultCode(CommonResultCode.USER_NOT_EXIST);
        }

        CourtDOCriteria courtDOCriteria = new CourtDOCriteria();
        courtDOCriteria.createCriteria().andUserIdEqualTo(userDO.getId());
        List<CourtDO> courtDOs = courtDOMapper.selectByExample(courtDOCriteria);
        if(CollectionUtils.isEmpty(courtDOs)){
            return BizResultHelper.newResultCode(CommonResultCode.PERSSION_ERROR);
        }
        goodsDO.setGmtModify(new Date());
        goodsDO.setGmtCreate(new Date());
        try {
            goodsDOMapper.insert(goodsDO);
            return BizResultHelper.newSuccess();
        }catch(Exception e){
             log.error("create error",e);
        }
        return BizResultHelper.newCommonError();
    }

    public BizResult update(String sid, GoodsDO goodsDO) {
        if (!StringUtils.hasText(sid) || goodsDO == null || goodsDO.getId()<1
                || !StringUtils.hasText(goodsDO.getGoodsName())
                || goodsDO.getPrice()<1) {
            return BizResultHelper.newResultCode(CommonResultCode.PARAM_MISS);
        }
        BizResult bizResult = sessionBiz.checkSession(sid);
        if (!bizResult.success) {
            return bizResult;
        }
        SessionDO sessionDO = (SessionDO) bizResult.data.get("sessionDO");
        UserDO userDO = userDOMapper.selectByPrimaryKey(sessionDO.getUserId());
        if (userDO == null) {
            return BizResultHelper.newResultCode(CommonResultCode.USER_NOT_EXIST);
        }

        CourtDOCriteria courtDOCriteria = new CourtDOCriteria();
        courtDOCriteria.createCriteria().andUserIdEqualTo(userDO.getId());
        List<CourtDO> courtDOs = courtDOMapper.selectByExample(courtDOCriteria);
        if(CollectionUtils.isEmpty(courtDOs)){
            return BizResultHelper.newResultCode(CommonResultCode.PERSSION_ERROR);
        }
        GoodsDO goodsDO1 = goodsDOMapper.selectByPrimaryKey(goodsDO.getId());
        if(goodsDO1 == null){
            return BizResultHelper.newResultCode(CommonResultCode.GOODS_NOT_EXIST);
        }
        goodsDO.setGmtModify(new Date());
        try {
            goodsDOMapper.updateByPrimaryKeySelective(goodsDO);
            return BizResultHelper.newSuccess();
        }catch(Exception e){
            log.error("create error",e);
        }
        return BizResultHelper.newCommonError();
    }

    public BizResult delete(String sid, int id) {
        if (!StringUtils.hasText(sid) || id<1) {
            return BizResultHelper.newResultCode(CommonResultCode.PARAM_MISS);
        }
        BizResult bizResult = sessionBiz.checkSession(sid);
        if (!bizResult.success) {
            return bizResult;
        }
        SessionDO sessionDO = (SessionDO) bizResult.data.get("sessionDO");
        UserDO userDO = userDOMapper.selectByPrimaryKey(sessionDO.getUserId());
        if (userDO == null) {
            return BizResultHelper.newResultCode(CommonResultCode.USER_NOT_EXIST);
        }

        CourtDOCriteria courtDOCriteria = new CourtDOCriteria();
        courtDOCriteria.createCriteria().andUserIdEqualTo(userDO.getId());
        List<CourtDO> courtDOs = courtDOMapper.selectByExample(courtDOCriteria);
        if(CollectionUtils.isEmpty(courtDOs)){
            return BizResultHelper.newResultCode(CommonResultCode.PERSSION_ERROR);
        }
        GoodsDO goodsDO1 = goodsDOMapper.selectByPrimaryKey(id);
        if(goodsDO1 == null){
            return BizResultHelper.newResultCode(CommonResultCode.GOODS_NOT_EXIST);
        }

        try {
            goodsDOMapper.deleteByPrimaryKey(id);
            return BizResultHelper.newSuccess();
        }catch(Exception e){
            log.error("delete error",e);
        }
        return BizResultHelper.newCommonError();
    }

    public BizResult queryListByCourtId(int courtId,int pageNo,int pageSize) {
        if (courtId<1) {
            return BizResultHelper.newResultCode(CommonResultCode.PARAM_MISS);
        }
        GoodsDOCriteria goodsDOCriteria = new GoodsDOCriteria();
        goodsDOCriteria.createCriteria().andCourtIdEqualTo(courtId);
        goodsDOCriteria.setOrderByClause("order by gmt_modify desc");
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNo(pageNo);
        baseQuery.setPageSize(pageSize);
        List<GoodsDO> goodsDOs = goodsDOMapper.selectByExample(goodsDOCriteria);
        int count = goodsDOMapper.countByExample(goodsDOCriteria);
        baseQuery.setTotalCount(count);
        BizResult bizResult = new BizResult();
        bizResult.success = true;
        bizResult.data.put("query",baseQuery);
        bizResult.data.put("goodsList",goodsDOs);
        return bizResult;
    }

    public BizResult queryOrderListByBuyer(String sid,int pageNo,int pageSize) {
        if (!StringUtils.hasText(sid)) {
            return BizResultHelper.newResultCode(CommonResultCode.PARAM_MISS);
        }
        BizResult bizResult = sessionBiz.checkSession(sid);
        if (!bizResult.success) {
            return bizResult;
        }
        SessionDO sessionDO = (SessionDO) bizResult.data.get("sessionDO");
        UserDO userDO = userDOMapper.selectByPrimaryKey(sessionDO.getUserId());
        if (userDO == null) {
            return BizResultHelper.newResultCode(CommonResultCode.USER_NOT_EXIST);
        }
        OrderDOCriteria orderDOCriteria = new OrderDOCriteria();
        orderDOCriteria.createCriteria().andBuyerIdEqualTo(userDO.getId());
        orderDOCriteria.setOrderByClause("order by gmt_modify desc");
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNo(pageNo);
        baseQuery.setPageSize(pageSize);
        List<OrderDO> orderDOs = orderDOMapper.selectByExample(orderDOCriteria);
        int count = orderDOMapper.countByExample(orderDOCriteria);
        baseQuery.setTotalCount(count);
        bizResult = new BizResult();
        bizResult.success = true;
        bizResult.data.put("query",baseQuery);
        bizResult.data.put("orderList",orderDOs);
        return bizResult;
    }

    public BizResult queryOrderListBySeller(String sid,int pageNo,int pageSize) {
        if (!StringUtils.hasText(sid)) {
            return BizResultHelper.newResultCode(CommonResultCode.PARAM_MISS);
        }
        BizResult bizResult = sessionBiz.checkSession(sid);
        if (!bizResult.success) {
            return bizResult;
        }
        SessionDO sessionDO = (SessionDO) bizResult.data.get("sessionDO");
        UserDO userDO = userDOMapper.selectByPrimaryKey(sessionDO.getUserId());
        if (userDO == null) {
            return BizResultHelper.newResultCode(CommonResultCode.USER_NOT_EXIST);
        }
        GoodsDOCriteria goodsDOCriteria = new GoodsDOCriteria();
        goodsDOCriteria.setOrderByClause("order by gmt_modify desc");
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNo(pageNo);
        baseQuery.setPageSize(pageSize);
        List<GoodsDO> goodsDOs = goodsDOMapper.selectByExample(goodsDOCriteria);
        int count = goodsDOMapper.countByExample(goodsDOCriteria);
        baseQuery.setTotalCount(count);
        bizResult = new BizResult();
        bizResult.success = true;
        bizResult.data.put("query",baseQuery);
        bizResult.data.put("goodsList",goodsDOs);
        return bizResult;
    }

    public BizResult buy(String sid, int id) {
        return null;
    }

    public BizResult cancelBuy(String sid, int tradeId) {
        return null;
    }
}
