package com.jiahanglee.journey.services;

import com.jiahanglee.journey.dto.OrderDTO;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/25 19:08
 * @Description: //TODO
 * @version: V1.0
 */
public interface PushMessage {

    void orderStatus(OrderDTO orderDTO);
}
