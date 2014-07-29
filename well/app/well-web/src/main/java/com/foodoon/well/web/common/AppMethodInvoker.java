package com.foodoon.well.web.common;


import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.text.ParseException;

/**
 * Created by foodoon on 2014/7/29.
 */
public class AppMethodInvoker {

    public AppResponse invoke(AppRequest appRequest,Method method){
        Object[] args = new Object[0];
        AppResponse appResponse = new AppResponse();
        try {
            args = resolveArguments(method, appRequest);
            Object res = null;
            if(args == null) {
                  res = ReflectionUtils.invokeMethod(method,appRequest.getAppHandle().getHandleObject());

            }else{
                 res =  ReflectionUtils.invokeMethod(method,appRequest.getAppHandle().getHandleObject(),args);
            }
            appResponse.setResult(res);
            appResponse.setSuccess(true);
            return appResponse;
        } catch (IllegalAccessException e) {
            appResponse.setErrorMsg(e.getMessage());
            e.printStackTrace();
        } catch (ParseException e) {
            appResponse.setErrorMsg(e.getMessage());
            e.printStackTrace();
        } catch (InstantiationException e) {
            appResponse.setErrorMsg(e.getMessage());
            e.printStackTrace();
        }
        return appResponse;
    }

    private Object[] resolveArguments(Method method,AppRequest appRequest) throws IllegalAccessException, ParseException, InstantiationException {
        Class[] paramTypes = method.getParameterTypes();
        if(paramTypes.length == 0){
            return null;
        }
        Object[] args = new Object[paramTypes.length];
        for (int i = 0; i < args.length; i++) {
            Class param = paramTypes[i];
            String val = appRequest.getRequestParams().get(param.getName());
            args[i] =  ReflectTool.resolveField(param, appRequest.getRequestParams(),val);
        }
        return args;
    }


}
