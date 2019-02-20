package com.jiahanglee.journey.services;

import com.jiahanglee.journey.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/20 20:40
 * @Description: //TODO
 * @version: V1.0
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);
}
