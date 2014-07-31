package com.foodoon.well.web.action.api;

import com.foodoon.tools.web.page.BaseQuery;
import com.foodoon.tools.web.page.BizResult;
import com.foodoon.tools.web.util.RequestUtil;
import com.foodoon.well.biz.entity.ApiDefine;
import com.foodoon.well.biz.entity.ApiFactory;
import com.foodoon.well.biz.entity.ApiKey;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by foodoon on 2014/7/31.
 */
@Controller
public class Index {

    private ApiFactory apiFactory;

    @RequestMapping(value = "api/list.htm", method = RequestMethod.GET)
    public String list(HttpServletRequest request, ModelMap modelMap) {

        return "api/list.vm";


    }

    @RequestMapping(value = "api/index.htm", method = RequestMethod.GET)
    public String index(HttpServletRequest request, ModelMap modelMap) {
        String apiName = request.getParameter("apiName");
        String apiVersion = request.getParameter("apiVersion");
        if(!StringUtils.hasText(apiName) || !StringUtils.hasText(apiVersion)){
            modelMap.put("errorMsg","api名称以及版本不能为空");
            return "api/index.vm";
        }
        ApiKey apiKey = new ApiKey(apiName,apiVersion);
        ApiDefine apiDefine = apiFactory.getApiMap().get(apiKey);
        if(apiDefine == null){
            modelMap.put("errorMsg","尚未配置api相关信息");
            return "api/index.vm";
        }
        modelMap.put("apiDefine",apiDefine);
        return "api/index.vm";


    }

    public void setApiFactory(ApiFactory apiFactory) {
        this.apiFactory = apiFactory;
    }
}
