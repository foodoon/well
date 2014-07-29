/**
 * zoneland.net Inc.
 * Copyright (c) 2002-2012 All Rights Reserved.
 */
package com.foodoon.well.web.action.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;

/**
 *
 * @author wangyong
 * @version $Id: BaseController.java, v 0.1 2012-8-11 上午9:58:21 wangyong Exp $
 */
public class BaseJsonController {
    /**
     * 日志对象
     */
    protected final Logger log = Logger.getLogger(getClass());

    public String toJson(Object obj) {
        if (obj == null) {
            return "{}";
        } else {
            return JSON.toJSONString(obj);
        }
    }

    public void ajaxReturn(Object obj, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/html;charset=UTF-8");
            out = response.getWriter();
            out.print(toJson(obj));
            out.flush();
        } catch (IOException e) {

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public void ajaxReturnObj(Object obj, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/json;charset=UTF-8");
            out = response.getWriter();
            out.print(obj);
            out.flush();
        } catch (IOException e) {

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public void ajaxReturnObjText(Object obj, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/plain;charset=UTF-8");
            out = response.getWriter();
            out.print(toJson(obj));
            out.flush();
        } catch (IOException e) {

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public void jsonReturn(Object obj, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setContentType("text/json;charset=UTF-8");
            out = response.getWriter();
            out.print(obj);
            out.flush();
        } catch (IOException e) {

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public void addMsg(ModelMap modelMap, String msg) {
        modelMap.addAttribute("msg", msg);
    }

    public void addErrorMsg(ModelMap modelMap, String msg) {
        modelMap.addAttribute("errorMsg", msg);
    }

    public void addSuccessMsg(ModelMap modelMap, String msg) {
        modelMap.addAttribute("successMsg", msg);
    }

}
