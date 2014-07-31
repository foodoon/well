package com.foodoon.well.biz.service;

import com.foodoon.well.dao.domain.ChallengeDO;
import com.foodoon.well.dao.domain.ChallengeMsgDO;


import java.util.List;

/**
 * Created by foodoon on 2014/7/31.
 */
public interface ChallengeService {


    public boolean create(ChallengeDO challengeDO);

    public boolean update(ChallengeDO challengeDO);

    public boolean delete(int id);

    public List<ChallengeMsgDO> queryList(int challengeId);

    public boolean comment(int challengeId,String msg);

}
