package com.foodoon.well.biz.service;

import com.foodoon.well.biz.entity.TeamApplyVO;
import com.foodoon.well.dao.domain.TeamDO;

import java.util.List;

/**
 * Created by foodoon on 2014/7/30.
 */
public interface TeamService {

    public boolean apply(int teamId,int userId);

    public boolean cancelApply(int applyId);

    public boolean create(TeamDO teamDO);

    public boolean update(TeamDO teamDO);

    public boolean delete(TeamDO teamDO);

    public List<TeamApplyVO> queryMyApplyList(int userId);

    public boolean passApply(int applyId);

    public boolean rejectApply(int applyId);

    public List<TeamApplyVO> queryApplyListForReview(int userId);

}
