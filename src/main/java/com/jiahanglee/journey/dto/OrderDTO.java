package com.jiahanglee.journey.dto;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jiahanglee.journey.dataobject.OrderDetail;
import com.jiahanglee.journey.enums.OrderStatusEnum;
import com.jiahanglee.journey.enums.PayStatusEnum;
import com.jiahanglee.journey.utils.Date2LongUtil;
import com.jiahanglee.journey.utils.EnumUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 21:47
 * @Description: //TODO
 * @version: V1.0
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus = OrderStatusEnum.New.getCode();
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    @JsonSerialize(using = Date2LongUtil.class)
    private Date createTime;
    @JsonSerialize(using = Date2LongUtil.class)
    private Date updateTime;
    // 通过new ArrayList（）返回[]
    private List<OrderDetail> orderDetails;
    @JsonIgnore
    public  OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}
