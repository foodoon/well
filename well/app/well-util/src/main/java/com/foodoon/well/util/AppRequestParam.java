package com.foodoon.well.util;


import java.lang.annotation.*;

/**
 * Created by foodoon on 2014/8/2.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AppRequestParam {


    public String value() ;


}
