package com.jiahanglee.journey.utils;

import java.util.Random;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 22:24
 * @Description: //TODO
 * @version: V1.0
 */
public class KeyUtil {

    public static synchronized String genUniqueKey() {

        Random random = new Random();

        System.currentTimeMillis();

        Integer a = random.nextInt(900000)+100000;

        return System.currentTimeMillis() + String.valueOf(a);
    }
}
