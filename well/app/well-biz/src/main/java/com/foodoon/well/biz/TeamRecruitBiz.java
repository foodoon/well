package com.foodoon.well.biz;

import com.foodoon.well.dao.domain.TeamRecruitDO;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public interface TeamRecruitBiz {

        BizResult detail(int id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(int id);

        BizResult create(TeamRecruitDO teamRecruitDO);

        BizResult update(TeamRecruitDO teamRecruitDO);

}
