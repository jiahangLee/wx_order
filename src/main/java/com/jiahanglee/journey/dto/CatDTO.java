package com.jiahanglee.journey.dto;

import lombok.Data;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 22:39
 * @Description: //TODO
 * @version: V1.0
 */
@Data
public class CatDTO {
    private String productId;
    private Integer productQuantity;

    public CatDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
