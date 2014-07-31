package com.foodoon.well.biz.service;

import com.foodoon.well.biz.entity.TeamApplyVO;
import com.foodoon.well.dao.domain.UserDO;
import com.foodoon.well.util.AppRequestMapping;

import java.util.List;

/**
 * Created by foodoon on 2014/7/30.
 */
public interface UserService {


    public boolean create(UserDO userDO);

    public boolean update(UserDO userDO);

    public UserDO queryByUserName(String userName);

    public UserDO login(String userName,String password);

    public boolean loginOut(String userName);


}
