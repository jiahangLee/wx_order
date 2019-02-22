package com.jiahanglee.journey.dataservice;

import com.jiahanglee.journey.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 21:42
 * @Description: //TODO
 * @version: V1.0
 */
public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);
    OrderDTO findOne(String orderId);
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);
    OrderDTO cancel(OrderDTO orderDTO);
    OrderDTO finish(OrderDTO orderDTO);
    OrderDTO pay(OrderDTO orderDTO);
    Page<OrderDTO> findList(Pageable pageable);
}
