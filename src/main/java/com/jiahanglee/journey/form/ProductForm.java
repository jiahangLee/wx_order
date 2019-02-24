package com.jiahanglee.journey.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/24 20:24
 * @Description: //TODO
 * @version: V1.0
 */
@Data
public class ProductForm {
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer categoryType;
}
