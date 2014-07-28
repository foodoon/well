package com.foodoon.well.biz;

import com.foodoon.well.dao.domain.CourtApplyDO;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public interface CourtApplyBiz {

        BizResult detail(int id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(int id);

        BizResult create(CourtApplyDO courtApplyDO);

        BizResult update(CourtApplyDO courtApplyDO);

}
