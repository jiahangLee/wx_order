package com.jiahanglee.journey.exception;

import com.jiahanglee.journey.enums.ResultEnum;
import lombok.Getter;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 22:05
 * @Description: //TODO
 * @version: V1.0
 */
@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
