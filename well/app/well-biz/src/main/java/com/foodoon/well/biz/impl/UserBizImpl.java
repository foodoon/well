package com.foodoon.well.biz.impl;

import java.util.Date;
import java.util.List;

import com.foodoon.well.dao.SessionDOMapper;
import com.foodoon.well.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.foodoon.well.biz.UserBiz;
import com.foodoon.well.dao.UserDOMapper;
import com.foodoon.well.dao.domain.UserDO;
import com.foodoon.well.dao.domain.UserDOCriteria;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public class UserBizImpl implements UserBiz{

    private final static Logger logger = LoggerFactory.getLogger(UserBizImpl.class);

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private SessionDOMapper sessionDOMapper;

    public BizResult detail(int id) {
        BizResult bizResult = new BizResult();
        try{
            UserDO userDO = userDOMapper.selectByPrimaryKey(id);
            bizResult.data.put("userDO", userDO);
            bizResult.success = true;
        }catch(Exception e){
            logger.error("query User error",e);
        }
        return bizResult;
}

    public BizResult list(BaseQuery baseQuery) {
        BizResult bizResult = new BizResult();
        try {
            UserDOCriteria userDOCriteria = new UserDOCriteria();
            userDOCriteria.setStartRow(baseQuery.getStartRow());
            userDOCriteria.setPageSize(baseQuery.getPageSize());
            int totalCount = userDOMapper.countByExample(userDOCriteria);
            baseQuery.setTotalCount(totalCount);
            List<UserDO> userDOList = userDOMapper.selectByExample(userDOCriteria);
            bizResult.data.put("userDOList", userDOList);
            bizResult.data.put("query", baseQuery);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("view User list error", e);
        }
            return bizResult;
     }

    public BizResult delete(int id) {
        BizResult bizResult = new BizResult();
        try {
            userDOMapper.deleteByPrimaryKey(id);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("delete user error", e);
        }
        return bizResult;
    }


    public BizResult create(UserDO userDO) {
        userDO.setGmtModify(new Date());
        userDO.setGmtCreate(new Date());
        BizResult bizResult = new BizResult();
        try {
            userDO.setGmtCreate(new Date());
            userDO.setGmtModify(new Date());
            int count = userDOMapper.insert(userDO);
            bizResult.data.put("count", userDO.getId());
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("create User error", e);
            bizResult.msg =ErrorCode.getMessage(CommonResultCode.DATABASE_ERRROR);
            bizResult.code=CommonResultCode.DATABASE_ERRROR;
        }
        return bizResult;
    }

    public BizResult update(UserDO userDO) {
        BizResult bizResult = new BizResult();
        try {
            int count = userDOMapper.updateByPrimaryKeySelective(userDO);
            bizResult.data.put("count", count);
            bizResult.success = true;
        } catch (Exception e) {
            logger.error("update User error", e);
        }
        return bizResult;
    }

    public BizResult login(String userName, String password) {
        BizResult bizResult = new BizResult();
        UserDOCriteria userDOCriteria = new UserDOCriteria();
        UserDOCriteria.Criteria criteria = userDOCriteria.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<UserDO> userDOs = userDOMapper.selectByExample(userDOCriteria);
        if(userDOs.size() == 0){
            BizResultHelper.setResultCode(bizResult,CommonResultCode.USER_NOT_EXIST);
            return bizResult;
        }else if(userDOs.size()>1){
            BizResultHelper.setResultCode(bizResult,CommonResultCode.USER_NAME_DUPLICATE);
            return bizResult;
        }

        //校验密码
        UserDO userDO = userDOs.get(0);
        if(!userDO.getPassword().equals(Md5.encode(password))){
            BizResultHelper.setResultCode(bizResult,CommonResultCode.USER_OR_PASSWORD_NOT_MATCH);
            return bizResult;
        }

        return null;
    }

    public BizResult loginOut(String sid) {
        return null;
    }

}
