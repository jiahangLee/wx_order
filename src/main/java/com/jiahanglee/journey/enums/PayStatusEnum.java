package com.jiahanglee.journey.enums;

import lombok.Getter;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 20:58
 * @Description: //TODO
 * @version: V1.0
 */
@Getter
public enum PayStatusEnum implements CodeEnum{

    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功");

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
