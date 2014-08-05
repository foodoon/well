package com.foodoon.well.biz.service;

import com.foodoon.tools.web.page.BizResult;
import com.foodoon.well.dao.domain.ChallengeDO;
import com.foodoon.well.dao.domain.ChallengeMsgDO;


import java.util.List;

/**
 * Created by foodoon on 2014/7/31.
 */
public interface ChallengeService {


    public BizResult create(String sid,ChallengeDO challengeDO);

    public BizResult update(String sid,ChallengeDO challengeDO);

    public BizResult delete(String sid,int id);

    public BizResult queryListForApply(String sid);

    public BizResult queryList(String sid);

    public BizResult comment(String sid,int challengeId,String msg);

    public BizResult apply(String sid,int challengeId);

    public BizResult cancelApply(String sid,int challengeId);

}
