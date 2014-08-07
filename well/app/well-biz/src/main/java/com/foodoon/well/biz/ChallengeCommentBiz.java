package com.foodoon.well.biz;

import com.foodoon.well.dao.domain.ChallengeCommentDO;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;

public interface ChallengeCommentBiz {

        BizResult detail(int id);

        BizResult list(BaseQuery baseQuery);

        BizResult delete(int id);

        BizResult create(ChallengeCommentDO challengeCommentDO);

        BizResult update(ChallengeCommentDO challengeCommentDO);

}
