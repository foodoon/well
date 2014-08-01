package com.foodoon.well.biz;

import com.foodoon.well.dao.domain.UserDO;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public interface UserBiz {

        BizResult detail(int id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(int id);

        BizResult create(UserDO userDO);

        BizResult update(UserDO userDO);

        BizResult login(String userName,String password);

        BizResult loginOut(String sid);


}
