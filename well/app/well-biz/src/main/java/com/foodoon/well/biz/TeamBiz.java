package com.foodoon.well.biz;

import com.foodoon.well.dao.domain.TeamDO;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public interface TeamBiz {

        BizResult detail(int id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(int id);

        BizResult create(TeamDO teamDO);

        BizResult update(TeamDO teamDO);

}
