package com.foodoon.well.biz.service.impl;

import com.foodoon.well.biz.service.UserService;
import com.foodoon.well.dao.domain.UserDO;
import com.foodoon.well.util.AppRequestMapping;

/**
 * Created by foodoon on 2014/7/31.
 */
public class UserServiceImpl implements UserService{

    @AppRequestMapping(apiName ="user.reg",apiVersion = "1.0")
    public boolean create(UserDO userDO) {
        return false;
    }

    @AppRequestMapping(apiName ="user.update",apiVersion = "1.0")
    public boolean update(UserDO userDO) {
        return false;
    }

    @AppRequestMapping(apiName ="user.queryByName",apiVersion = "1.0")
    public UserDO queryByUserName(String userName) {
        return null;
    }

    @AppRequestMapping(apiName ="user.login",apiVersion = "1.0")
    public UserDO login(String userName, String password) {
        return null;
    }

    @AppRequestMapping(apiName ="user.loginOut",apiVersion = "1.0")
    public boolean loginOut(String userName) {
        return false;
    }
}
