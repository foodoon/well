package com.foodoon.well.biz;

import com.foodoon.well.dao.domain.ChallengeDO;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public interface ChallengeBiz {

        BizResult detail(int id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(int id);

        BizResult create(ChallengeDO challengeDO);

        BizResult update(ChallengeDO challengeDO);

}
