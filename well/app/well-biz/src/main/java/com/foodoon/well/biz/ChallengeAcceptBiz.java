package com.foodoon.well.biz;

import com.foodoon.well.dao.domain.ChallengeAcceptDO;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public interface ChallengeAcceptBiz {

        BizResult detail(int id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(int id);

        BizResult create(ChallengeAcceptDO challengeAcceptDO);

        BizResult update(ChallengeAcceptDO challengeAcceptDO);

}
