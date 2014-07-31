package com.foodoon.well.biz.service;

import com.foodoon.tools.web.page.BizResult;
import com.foodoon.well.biz.entity.TeamApplyVO;
import com.foodoon.well.dao.domain.UserDO;
import com.foodoon.well.util.AppRequestMapping;

import java.util.List;

/**
 * Created by foodoon on 2014/7/30.
 */
public interface UserService {


    public BizResult create(UserDO userDO);

    public BizResult update(UserDO userDO);

    public BizResult queryByUserName(String userName);

    public BizResult login(String userName,String password);

    public BizResult loginOut(String userName);


}
