package com.jiahanglee.journey.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/20 21:09
 * @Description: //TODO
 * @version: V1.0
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson  = gsonBuilder.create();
        return gson.toJson(object);
    }
}
