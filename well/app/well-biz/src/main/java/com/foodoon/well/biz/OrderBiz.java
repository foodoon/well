package com.foodoon.well.biz;

import com.foodoon.well.dao.domain.OrderDO;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public interface OrderBiz {

        BizResult detail(int id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(int id);

        BizResult create(OrderDO orderDO);

        BizResult update(OrderDO orderDO);

}
