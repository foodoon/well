package com.foodoon.well.biz.service;

import com.foodoon.tools.web.page.BizResult;
import com.foodoon.well.biz.entity.TeamApplyVO;
import com.foodoon.well.dao.domain.TeamDO;

import java.util.List;

/**
 * Created by foodoon on 2014/7/30.
 */
public interface TeamService {

    public BizResult apply(String sid,int teamId);

    public BizResult cancelApply(String sid,int applyId);

    public BizResult create(String sid,TeamDO teamDO);

    public BizResult update(String sid,TeamDO teamDO);

    public BizResult delete(String sid,int id);

    public BizResult queryMyApplyList(String sid,int pageNo,int pageSize);

    public BizResult passApply(String sid,int applyId);

    public BizResult rejectApply(String sid,int applyId);

    public BizResult queryApplyListForReview(String sid,int pageNo,int pageSize);

    public BizResult removeMember(String sid,int removeUserId);

    public BizResult queryMemberList(String sid,int pageNo,int pageSize);

}
