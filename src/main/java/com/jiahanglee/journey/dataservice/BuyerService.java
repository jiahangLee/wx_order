package com.jiahanglee.journey.dataservice;

import com.jiahanglee.journey.dto.OrderDTO;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/18 19:46
 * @Description: //TODO
 * @version: V1.0
 */
public interface BuyerService {

    OrderDTO findOrderOne(String openid,String orderId);
    OrderDTO cancelOrder(String openid,String orderId);
}
