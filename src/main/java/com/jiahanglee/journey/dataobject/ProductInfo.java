package com.jiahanglee.journey.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jiahanglee.journey.enums.ProductStatusEnum;
import com.jiahanglee.journey.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 13:50
 * @Description: //TODO
 * @version: V1.0
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer productStatus = ProductStatusEnum.UP.getCode();
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;
    @JsonIgnore
    public  ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(getProductStatus(),ProductStatusEnum.class);
    }
}
