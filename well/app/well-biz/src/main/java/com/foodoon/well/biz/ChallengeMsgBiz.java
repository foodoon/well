package com.foodoon.well.biz;

import com.foodoon.well.dao.domain.ChallengeMsgDO;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public interface ChallengeMsgBiz {

        BizResult detail(int id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(int id);

        BizResult create(ChallengeMsgDO challengeMsgDO);

        BizResult update(ChallengeMsgDO challengeMsgDO);

}
