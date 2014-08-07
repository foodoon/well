package com.foodoon.well.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodoon.well.biz.ChallengeCommentBiz;
import com.foodoon.well.dao.domain.ChallengeCommentDO;
import com.foodoon.well.web.form.ChallengeCommentEditForm;
import com.foodoon.well.web.form.ChallengeCommentForm;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;
import com.foodoon.tools.web.util.RequestUtil;


@Controller
public class ChallengeCommentAction {


    @Autowired
    private ChallengeCommentBiz challengeCommentBiz;

    @RequestMapping(value = "challengeComment/list.htm", method = RequestMethod.GET)
    public String list(HttpServletRequest request, ModelMap modelMap) {
        int pageId = RequestUtil.getInt(request, "pageNo");
        int pageSize = RequestUtil.getInt(request, "pageSize");
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNo(pageId);
        modelMap.put("query",baseQuery);
        BizResult bizResult = challengeCommentBiz.list(baseQuery);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "challengeComment/list.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "challengeComment/edit.htm", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, ModelMap modelMap, ChallengeCommentEditForm challengeCommentEditForm,
        BindingResult result, Map<String,Object> model) {
        int id = RequestUtil.getInt(request, "id");
        BizResult bizResult = challengeCommentBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            challengeCommentEditForm.initForm(((ChallengeCommentDO)bizResult.data.get("challengeCommentDO")));
            return "challengeComment/edit.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "challengeComment/detail.htm", method = RequestMethod.GET)
    public String detail(HttpServletRequest request, ModelMap modelMap) {
        int id = RequestUtil.getInt(request, "id");
        BizResult bizResult = challengeCommentBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "challengeComment/detail.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "challengeComment/create.htm", method = RequestMethod.GET)
    public String create(HttpServletRequest request, ModelMap modelMap, ChallengeCommentForm challengeCommentForm,
        BindingResult result, Map<String,Object> model) {
        return "challengeComment/create.vm";
    }

    @RequestMapping(value = "challengeComment/doCreate.htm", method = RequestMethod.POST)
    public String doCreate(HttpServletRequest request, ModelMap modelMap,@Valid  ChallengeCommentForm challengeCommentForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "challengeComment/create.vm";
        }
        ChallengeCommentDO challengeCommentDO = challengeCommentForm.toDO();
        BizResult bizResult = challengeCommentBiz.create(challengeCommentDO);
        if (bizResult.success) {
            return "redirect:/challengeComment/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "challengeComment/doUpdate.htm", method = RequestMethod.POST)
    public String doUpdate(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap,@Valid ChallengeCommentEditForm challengeCommentEditForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "challengeComment/edit.vm";
        }
        ChallengeCommentDO challengeCommentDO = challengeCommentEditForm.toDO();
        BizResult bizResult = challengeCommentBiz.update(challengeCommentDO);
        if (bizResult.success) {
            return "redirect:/challengeComment/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "challengeComment/doDelete.htm")
    public String doDelete(HttpServletRequest request, ModelMap modelMap) {
        int id = RequestUtil.getInt(request, "id");
        BizResult bizResult = challengeCommentBiz.delete(id);
        if (bizResult.success) {
            return "challengeComment/list.htm";
        } else {
            return "common/error.vm";
        }

    }



}
