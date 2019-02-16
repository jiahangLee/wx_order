package com.jiahanglee.journey.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 15:57
 * @Description: //TODO
 * @version: V1.0
 */
@Data
public class ProductInfoVo {

    @JsonProperty("id")
    private String productId;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("price")
    private BigDecimal productPrice;
    @JsonProperty("description")
    private String productDescription;
    @JsonProperty("icon")
    private String productIcon;

}
