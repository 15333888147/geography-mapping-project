package com.aaa.gpm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: gcy
 * @DateTime: 2020/7/15 15:16
 * @Description: TODO
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginAnnotation {
    /**@DateTime: 2020/7/15 15:18
    * @Params: []
    * @Return java.lang.String
    * 描述：
     *      操作类型
    */
    String opeationType();

    /**@DateTime: 2020/7/15 15:18
    * @Params: []
    * @Return java.lang.String
    * 描述：
     *      执行的具体操作类型
    */
    String opeationName();
}
