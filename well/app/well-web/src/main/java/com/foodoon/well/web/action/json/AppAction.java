package com.foodoon.well.web.action.json;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by foodoon on 2014/7/29.
 */
@Controller
public class AppAction {

    @RequestMapping(value = "app.htm", method = RequestMethod.GET)
    public String execute(HttpServletRequest request, ModelMap modelMap) {
        //TODO 校验签名
        //TODO 校验登录
        //TODO
        String method=request.getParameter("m");
        return null;
    }
}
