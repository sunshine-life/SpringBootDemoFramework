package com.example.utils;



import com.alibaba.fastjson.JSON;

import java.util.Map;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;


public class JsonUtils {


    @SuppressWarnings("unchecked")
    public static Map<String,Object> json2Map(String json){
        return JSON.parseObject(json, Map.class);
    }

    public static String obj2JsonString(Object obj){
        return JSON.toJSONString(obj);
    }

}