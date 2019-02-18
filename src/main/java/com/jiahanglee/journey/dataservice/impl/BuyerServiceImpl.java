package com.jiahanglee.journey.dataservice.impl;

import com.jiahanglee.journey.dataservice.BuyerService;
import com.jiahanglee.journey.dataservice.OrderService;
import com.jiahanglee.journey.dto.OrderDTO;
import com.jiahanglee.journey.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/18 19:48
 * @Description: //TODO
 * @version: V1.0
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        //判空
        if (orderDTO == null || !orderDTO.getBuyerOpenid().equals(openid) ) {
            log.error("不是本人或为空");
//            throw new SellException()
        }
        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {

        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null || !orderDTO.getBuyerOpenid().equals(openid)) {
            log.error("不是本人或为空");
//            throw new SellException()
        }
        return orderService.cancel(orderDTO);
    }
}
