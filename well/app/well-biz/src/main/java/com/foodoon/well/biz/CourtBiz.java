package com.foodoon.well.biz;

import com.foodoon.well.dao.domain.CourtDO;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public interface CourtBiz {

        BizResult detail(int id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(int id);

        BizResult create(CourtDO courtDO);

        BizResult update(CourtDO courtDO);

}
