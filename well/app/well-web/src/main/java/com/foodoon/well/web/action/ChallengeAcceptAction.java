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

import com.foodoon.well.biz.ChallengeAcceptBiz;
import com.foodoon.well.dao.domain.ChallengeAcceptDO;
import com.foodoon.well.web.form.ChallengeAcceptEditForm;
import com.foodoon.well.web.form.ChallengeAcceptForm;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;
import com.foodoon.tools.web.util.RequestUtil;


@Controller
public class ChallengeAcceptAction {


    @Autowired
    private ChallengeAcceptBiz challengeAcceptBiz;

    @RequestMapping(value = "challengeAccept/list.htm", method = RequestMethod.GET)
    public String list(HttpServletRequest request, ModelMap modelMap) {
        int pageId = RequestUtil.getInt(request, "pageNo");
        int pageSize = RequestUtil.getInt(request, "pageSize");
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNo(pageId);
        modelMap.put("query",baseQuery);
        BizResult bizResult = challengeAcceptBiz.list(baseQuery);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "challengeAccept/list.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "challengeAccept/edit.htm", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, ModelMap modelMap, ChallengeAcceptEditForm challengeAcceptEditForm,
        BindingResult result, Map<String,Object> model) {
        int id = RequestUtil.getInt(request, "id");
        BizResult bizResult = challengeAcceptBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            challengeAcceptEditForm.initForm(((ChallengeAcceptDO)bizResult.data.get("challengeAcceptDO")));
            return "challengeAccept/edit.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "challengeAccept/detail.htm", method = RequestMethod.GET)
    public String detail(HttpServletRequest request, ModelMap modelMap) {
        int id = RequestUtil.getInt(request, "id");
        BizResult bizResult = challengeAcceptBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "challengeAccept/detail.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "challengeAccept/create.htm", method = RequestMethod.GET)
    public String create(HttpServletRequest request, ModelMap modelMap, ChallengeAcceptForm challengeAcceptForm,
        BindingResult result, Map<String,Object> model) {
        return "challengeAccept/create.vm";
    }

    @RequestMapping(value = "challengeAccept/doCreate.htm", method = RequestMethod.POST)
    public String doCreate(HttpServletRequest request, ModelMap modelMap,@Valid ChallengeAcceptForm challengeAcceptForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "challengeAccept/create.vm";
        }
        ChallengeAcceptDO challengeAcceptDO = challengeAcceptForm.toDO();
        BizResult bizResult = challengeAcceptBiz.create(challengeAcceptDO);
        if (bizResult.success) {
            return "redirect:/challengeAccept/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "challengeAccept/doUpdate.htm", method = RequestMethod.POST)
    public String doUpdate(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap,@Valid ChallengeAcceptEditForm challengeAcceptEditForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "challengeAccept/edit.vm";
        }
        ChallengeAcceptDO challengeAcceptDO = challengeAcceptEditForm.toDO();
        BizResult bizResult = challengeAcceptBiz.update(challengeAcceptDO);
        if (bizResult.success) {
            return "redirect:/challengeAccept/list.htm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "challengeAccept/doDelete.htm", method = RequestMethod.GET)
    public String doDelete(HttpServletRequest request, ModelMap modelMap) {
        int id = RequestUtil.getInt(request, "id");
        BizResult bizResult = challengeAcceptBiz.delete(id);
        if (bizResult.success) {
            return "redirect:/challengeAccept/list.htm";
        } else {
            return "common/error.vm";
        }

    }



}
