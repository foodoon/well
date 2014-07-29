package com.foodoon.well.web.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * Created by foodoon on 2014/7/29.
 */
public class AppAnnotationBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    private AppServiceFactory appServiceFactory;

    @Override
    public boolean postProcessAfterInstantiation(final Object bean, final String beanName) throws BeansException {
        ReflectionUtils.doWithMethods(bean.getClass(),new ReflectionUtils.MethodCallback(){

            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                AppRequestMapping annotation = method.getAnnotation(AppRequestMapping.class);
                if(annotation!=null){
                    String apiName = annotation.apiName();
                    String apiVersion = annotation.apiVersion();
                    if(!StringUtils.hasText(apiName)||!StringUtils.hasText(apiVersion)){
                        throw new RuntimeException("apiName or apiVersion cannot null.bean class:" + bean.getClass());
                    }
                    AppRequestKey appRequestKey = new AppRequestKey();
                    appRequestKey.setApiVersion(apiVersion);
                    appRequestKey.setApiName(apiName);
                    AppHandle appHandle = new AppHandle();
                    appHandle.setBeanName(beanName);
                    appHandle.setHandleMethod(method);
                    appHandle.setHandleObject(bean);

                    appServiceFactory.registerService(appRequestKey,appHandle);
                }
            }
        });

        return true;
    }
}
