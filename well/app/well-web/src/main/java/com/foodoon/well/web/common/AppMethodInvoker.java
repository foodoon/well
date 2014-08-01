package com.foodoon.well.web.common;


import com.foodoon.well.util.AppRequestParam;
import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.ParseException;

/**
 * Created by foodoon on 2014/7/29.
 */
public class AppMethodInvoker {

    public AppResponse invoke(AppRequest appRequest, AppHandle appHandle) throws NotFoundException, IllegalAccessException, ParseException, InstantiationException {
        Object[] args = new Object[0];
        AppResponse appResponse = new AppResponse();

        args = resolveArguments(appHandle, appRequest);
        Object res = null;
        if (args == null) {
            res = ReflectionUtils.invokeMethod(appHandle.getHandleMethod(), appRequest.getAppHandle().getHandleObject());

        } else {
            res = ReflectionUtils.invokeMethod(appHandle.getHandleMethod(), appRequest.getAppHandle().getHandleObject(), args);
        }
        appResponse.setResult(res);
        appResponse.setSuccess(true);
        return appResponse;
    }

    private Object[] resolveArguments(AppHandle appHandle, AppRequest appRequest) throws IllegalAccessException, ParseException, InstantiationException, NotFoundException {
        Class[] paramTypes = appHandle.getHandleMethod().getParameterTypes();
        if (paramTypes.length == 0) {
            return null;
        }
        Annotation[][] parameterAnnotations = appHandle.getHandleMethod().getParameterAnnotations();
        Object[] args = new Object[paramTypes.length];
        for (int i = 0; i < args.length; i++) {
            Class param = paramTypes[i];
            Annotation[] parameterAnnotation = parameterAnnotations[i];
            if(parameterAnnotation!=null && parameterAnnotation.length>0 && parameterAnnotation[0] instanceof  AppRequestParam) {
                String val = appRequest.getRequestParams().get(((AppRequestParam)parameterAnnotation[0]).value());
                args[i] = ReflectTool.resolveField(param, appRequest.getRequestParams(), val);
            }else{
                args[i] = ReflectTool.resolveField(param, appRequest.getRequestParams(), null);
            }
        }
        return args;
    }

    private String[] resovleParamName(Class clazz, String methodName) throws NotFoundException {

        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath(new ClassClassPath(clazz));
        CtClass cc = pool.get(clazz.getName());
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute
                .getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            return new String[]{};
        }
        String[] paramNames = new String[cm.getParameterTypes().length];
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < paramNames.length; i++) {
            paramNames[i] = attr.variableName(i + pos + 1);
        }
        return paramNames;
    }


}
