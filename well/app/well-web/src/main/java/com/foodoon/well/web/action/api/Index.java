package com.foodoon.well.web.action.api;

import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;
import com.foodoon.tools.web.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by foodoon on 2014/7/31.
 */
@Controller
public class Index {

    @RequestMapping(value = "api/list.htm", method = RequestMethod.GET)
    public String list(HttpServletRequest request, ModelMap modelMap) {

        return "api/list.vm";


    }

    @RequestMapping(value = "api/index.htm", method = RequestMethod.GET)
    public String index(HttpServletRequest request, ModelMap modelMap) {

            return "api/index.vm";


    }

}
