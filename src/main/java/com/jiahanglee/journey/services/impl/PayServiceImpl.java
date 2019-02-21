package com.jiahanglee.journey.services.impl;

import com.jiahanglee.journey.dataservice.OrderService;
import com.jiahanglee.journey.dto.OrderDTO;
import com.jiahanglee.journey.enums.ResultEnum;
import com.jiahanglee.journey.exception.SellException;
import com.jiahanglee.journey.services.PayService;
import com.jiahanglee.journey.utils.JsonUtil;
import com.jiahanglee.journey.utils.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/20 20:40
 * @Description: //TODO
 * @version: V1.0
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    @Autowired
    private BestPayServiceImpl bestPayService;
    @Autowired
    private OrderService orderService;

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName("微信点餐");
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("微信支付，request={}", JsonUtil.toJson(payRequest));
        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付】response={}",payResponse);
        return payResponse;
    }

    @Override
    public PayResponse notify(String notifyDate) {
        //验证签名
        //检测支付状态

        //支付金额
        //支付人和买家是否是同一个人

        PayResponse payResponse = bestPayService.asyncNotify(notifyDate);
        log.info("【微信支付】异步通知，payResponse={}",JsonUtil.toJson(payResponse));

        // 查询订单
        // 修改订单支付状态
        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());
        if(orderDTO == null) {
            log.error("【微信支付】 异步通知，订单不存在，orderId={}");
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        if(!MathUtil.equals(orderDTO.getOrderAmount().doubleValue(),payResponse.getOrderAmount())) {
            log.error("");
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        orderService.pay(orderDTO);
        return payResponse;
    }

}
