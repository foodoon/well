package com.foodoon.well.biz;

import com.foodoon.well.dao.domain.SessionDO;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public interface SessionBiz {

        BizResult detail(int id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(int id);

        BizResult create(SessionDO sessionDO);

        BizResult update(SessionDO sessionDO);

        SessionDO querySessionBySID(String sid);

        BizResult checkSession(String sid);



}
