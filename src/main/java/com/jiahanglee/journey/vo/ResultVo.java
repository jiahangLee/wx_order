package com.jiahanglee.journey.vo;

import lombok.Data;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 15:42
 * @Description: //TODO
 * @version: V1.0
 */
@Data
public class ResultVo<T> {

    private Integer code;
    private String msg;
    private T data;
}
