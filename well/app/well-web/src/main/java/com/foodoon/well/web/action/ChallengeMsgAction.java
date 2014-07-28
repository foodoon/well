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

import com.foodoon.well.biz.ChallengeMsgBiz;
import com.foodoon.well.dao.domain.ChallengeMsgDO;
import com.foodoon.well.web.form.ChallengeMsgEditForm;
import com.foodoon.well.web.form.ChallengeMsgForm;
import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;
import com.foodoon.tools.web.util.RequestUtil;


@Controller
public class ChallengeMsgAction {


    @Autowired
    private ChallengeMsgBiz challengeMsgBiz;

    @RequestMapping(value = "challengeMsg/list.htm", method = RequestMethod.GET)
    public String list(HttpServletRequest request, ModelMap modelMap) {
        int pageId = RequestUtil.getInt(request, "pageNo");
        int pageSize = RequestUtil.getInt(request, "pageSize");
        BaseQuery baseQuery = new BaseQuery();
        baseQuery.setPageNo(pageId);
        baseQuery.setPageSize(pageSize);
        BizResult bizResult = challengeMsgBiz.list(baseQuery);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "challengeMsg/list.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "challengeMsg/edit.htm", method = RequestMethod.GET)
    public String edit(HttpServletRequest request, ModelMap modelMap, ChallengeMsgEditForm challengeMsgEditForm,
        BindingResult result, Map<String,Object> model) {
        int id = RequestUtil.getInt(request, "id");
        BizResult bizResult = challengeMsgBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            challengeMsgEditForm.initForm(((ChallengeMsgDO)bizResult.data.get("challengeMsgDO")));
            return "challengeMsg/edit.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "challengeMsg/detail.htm", method = RequestMethod.GET)
    public String detail(HttpServletRequest request, ModelMap modelMap) {
        int id = RequestUtil.getInt(request, "id");
        BizResult bizResult = challengeMsgBiz.detail(id);
        if (bizResult.success) {
            modelMap.putAll(bizResult.data);
            return "challengeMsg/detail.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "challengeMsg/create.htm", method = RequestMethod.GET)
    public String create(HttpServletRequest request, ModelMap modelMap, ChallengeMsgForm challengeMsgForm,
        BindingResult result, Map<String,Object> model) {
        return "challengeMsg/create.vm";
    }

    @RequestMapping(value = "challengeMsg/doCreate.htm", method = RequestMethod.POST)
    public String doCreate(HttpServletRequest request, ModelMap modelMap,@Valid ChallengeMsgForm challengeMsgForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "challengeMsg/create.vm";
        }
        ChallengeMsgDO challengeMsgDO = challengeMsgForm.toDO();
        BizResult bizResult = challengeMsgBiz.create(challengeMsgDO);
        if (bizResult.success) {
            return "redirect:/challengeMsg/list.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "challengeMsg/doUpdate.htm", method = RequestMethod.POST)
    public String doUpdate(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap,@Valid ChallengeMsgEditForm challengeMsgEditForm,
        BindingResult result, Map<String,Object> model) {
        if (result.hasErrors()) {
            return "challengeMsg/edit.vm";
        }
        ChallengeMsgDO challengeMsgDO = challengeMsgEditForm.toDO();
        BizResult bizResult = challengeMsgBiz.update(challengeMsgDO);
        if (bizResult.success) {
            return "redirect:/challengeMsg/list.vm";
        } else {
            return "common/error.vm";
        }

    }

    @RequestMapping(value = "challengeMsg/doDelete.htm", method = RequestMethod.POST)
    public String doDelete(HttpServletRequest request, ModelMap modelMap) {
        int id = RequestUtil.getInt(request, "id");
        BizResult bizResult = challengeMsgBiz.delete(id);
        if (bizResult.success) {
            return "challengeMsg/list.vm";
        } else {
            return "common/error.vm";
        }

    }



}
