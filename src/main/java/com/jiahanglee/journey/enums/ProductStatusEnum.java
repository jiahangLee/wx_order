package com.jiahanglee.journey.enums;

import lombok.Getter;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 14:57
 * @Description: //TODO
 * @version: V1.0
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{

    UP(0,"上架"),
    DOWN(1,"下架");

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;
}
