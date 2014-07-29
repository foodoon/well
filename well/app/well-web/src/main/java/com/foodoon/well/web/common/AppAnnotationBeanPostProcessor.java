package com.foodoon.well.web.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by foodoon on 2014/7/29.
 */
public class AppAnnotationBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    @Override
    public boolean postProcessAfterInstantiation(final Object bean, String beanName) throws BeansException {
        ReflectionUtils.doWithMethods(bean.getClass(),new ReflectionUtils.MethodCallback(){

            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                AppRequest annotation = method.getAnnotation(AppRequest.class);
                if(annotation!=null){

                }
            }
        });

        return true;
    }
}
