package com.jiahanglee.journey.utils;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/21 15:56
 * @Description: //TODO
 * @version: V1.0
 */
public class MathUtil {

    private static final Double MONEY_PANGE = 0.01;
    public static Boolean equals(Double d1,double d2) {
        return Math.abs(d1 - d2) < MONEY_PANGE;
    }
}
