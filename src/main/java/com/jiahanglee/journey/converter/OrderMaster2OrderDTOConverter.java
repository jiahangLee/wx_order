package com.jiahanglee.journey.converter;

import com.jiahanglee.journey.dataobject.OrderMaster;
import com.jiahanglee.journey.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/17 09:27
 * @Description: //TODO
 * @version: V1.0
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO converter(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
    public static List<OrderDTO> convert(List<OrderMaster> orderMasters){
        return orderMasters.stream().map(e -> converter(e))
                .collect(Collectors.toList());
    }
}
