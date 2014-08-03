package com.foodoon.well.biz;

import com.foodoon.well.dao.domain.TeamMemberDO;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public interface TeamMemberBiz {

        BizResult detail(int id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(int id);

        BizResult create(TeamMemberDO teamMemberDO);

        BizResult update(TeamMemberDO teamMemberDO);

}
