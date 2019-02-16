package com.jiahanglee.journey.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 15:53
 * @Description: //TODO
 * @version: V1.0
 */
@Data
public class ProductVo {

    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;

}
