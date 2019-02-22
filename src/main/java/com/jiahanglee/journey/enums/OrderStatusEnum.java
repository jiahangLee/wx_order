package com.jiahanglee.journey.enums;

import lombok.Getter;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 20:53
 * @Description: //TODO
 * @version: V1.0
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{

    New(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消");

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public  static OrderStatusEnum getOrderStatusEnum(Integer code) {
        for (OrderStatusEnum orderStatusEnum:OrderStatusEnum.values()) {
            if (orderStatusEnum.getCode().equals(code)) {
                return orderStatusEnum;
            }
        }
        return null;
    }
}
