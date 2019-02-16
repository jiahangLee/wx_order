package com.jiahanglee.journey.exception;

import com.jiahanglee.journey.enums.ResultEnum;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 22:05
 * @Description: //TODO
 * @version: V1.0
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
