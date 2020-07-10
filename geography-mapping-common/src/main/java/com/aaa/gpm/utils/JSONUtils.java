package com.aaa.gpm.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @Author: zj
 * @Date: 2020/7/10
 *  json 转换工具类
 */
public class JSONUtils {

    /**
     * 定义私有静态常量ObjectMapper(命名规则：所有字母全部大写，单词与单词之间使用_连接)
     *  ObjectMapper：就是fastjson包中进行类转换的工具类
     */
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 把对象转换为json字符串
     * @param object
     * @return
     */
    public static String toJsonString(Object object){
        try {
            String jsonString = OBJECT_MAPPER.writeValueAsString(object);
            return jsonString;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 把json转换为指定对象
     *      <T>：定义一个类型
     *      T：返回值的类型
     * @param jsonData 传入的json对象
     * @param beanType 所需转换对象的目标类型
     * @param <T>
     * @return
     */
    public static <T> T toObject(String jsonData, Class<T> beanType){
        try {
            T t = OBJECT_MAPPER.readValue(jsonData,beanType);
            return t;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> toList(String jsonData, Class<T> beanType){
        /**
         * 为list集合添加一个指定的泛型
         *      List  User.class ---> 通过constructParametricType方法把List和User合并，也就是说为List指定一个User对象的泛型(List<User>)
         */
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = OBJECT_MAPPER.readValue(jsonData, javaType);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
