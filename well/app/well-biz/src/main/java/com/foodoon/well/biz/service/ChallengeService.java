package com.foodoon.well.biz.service;

import com.foodoon.tools.web.page.BizResult;
import com.foodoon.well.dao.domain.ChallengeDO;

/**
 * Created by foodoon on 2014/7/31.
 */
public interface ChallengeService {


    public BizResult create(String sid,ChallengeDO challengeDO);

    public BizResult update(String sid,ChallengeDO challengeDO);

    public BizResult delete(String sid,int id);

    public BizResult queryListForApply(String sid,int pageNo,int pageSize);

    public BizResult queryMyChallengeList(String sid,int pageNo,int pageSize);

    public BizResult queryMyApplyList(String sid,int pageNo,int pageSize);

    public BizResult comment(String sid,int challengeId,String msg);

    public BizResult apply(String sid,int challengeId);

    public BizResult cancelApply(String sid,int challengeId);

    public BizResult passApply(String sid,int challengeApplyId);

    public BizResult rejectApply(String sid,int challengeApplyId);

}
