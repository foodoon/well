package com.foodoon.well.biz.service;

import com.foodoon.well.dao.domain.ChallengeDO;
import com.foodoon.well.dao.domain.ChallengeMsgDO;


import java.util.List;

/**
 * Created by foodoon on 2014/7/31.
 */
public interface ChallengeService {


    public boolean create(String sid,ChallengeDO challengeDO);

    public boolean update(String sid,ChallengeDO challengeDO);

    public boolean delete(String sid,int id);

    public List<ChallengeMsgDO> queryList(String sid,int challengeId);

    public boolean comment(String sid,int challengeId,String msg);

}
