package com.jiahanglee.journey.utils;

import com.jiahanglee.journey.enums.CodeEnum;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/22 12:06
 * @Description: //TODO
 * @version: V1.0
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code,Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if(code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}

