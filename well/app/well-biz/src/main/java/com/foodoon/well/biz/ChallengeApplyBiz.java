package com.foodoon.well.biz;

import com.foodoon.well.dao.domain.ChallengeApplyDO;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public interface ChallengeApplyBiz {

        BizResult detail(int id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(int id);

        BizResult create(ChallengeApplyDO challengeApplyDO);

        BizResult update(ChallengeApplyDO challengeApplyDO);

}
