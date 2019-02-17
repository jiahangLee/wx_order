package com.jiahanglee.journey.enums;

import lombok.Getter;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 22:06
 * @Description: //TODO
 * @version: V1.0
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"无库存"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDER_DETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态不正常"),
    ORDER_PAY_ERROR(15,"支付状态不正常"),
    ORDER_UPDATE_ERROR(16,"订单更新失败");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
