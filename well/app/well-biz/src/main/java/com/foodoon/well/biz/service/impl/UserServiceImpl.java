package com.foodoon.well.biz.service.impl;

import com.foodoon.tools.web.page.BizResult;
import com.foodoon.well.biz.UserBiz;
import com.foodoon.well.biz.service.UserService;
import com.foodoon.well.dao.domain.UserDO;
import com.foodoon.well.util.AppRequestMapping;

/**
 * Created by foodoon on 2014/7/31.
 */
public class UserServiceImpl implements UserService{

    private UserBiz userBiz;

    @AppRequestMapping(apiName ="user.reg",apiVersion = "1.0")
    public BizResult create(UserDO userDO) {
        return  userBiz.create(userDO);
    }

    @AppRequestMapping(apiName ="user.update",apiVersion = "1.0")
    public BizResult update(UserDO userDO) {
        return null;
    }

    @AppRequestMapping(apiName ="user.queryByName",apiVersion = "1.0")
    public BizResult queryByUserName(String userName) {
        return null;
    }

    @AppRequestMapping(apiName ="user.login",apiVersion = "1.0")
    public BizResult login(String userName, String password) {
        return null;
    }

    @AppRequestMapping(apiName ="user.loginOut",apiVersion = "1.0")
    public BizResult loginOut(String userName) {
        return null;
    }

    public void setUserBiz(UserBiz userBiz) {
        this.userBiz = userBiz;
    }
}
