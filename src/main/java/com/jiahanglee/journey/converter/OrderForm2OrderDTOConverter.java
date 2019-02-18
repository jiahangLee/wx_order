package com.jiahanglee.journey.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jiahanglee.journey.dataobject.OrderDetail;
import com.jiahanglee.journey.dto.OrderDTO;
import com.jiahanglee.journey.enums.ResultEnum;
import com.jiahanglee.journey.exception.SellException;
import com.jiahanglee.journey.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/18 14:43
 * @Description: //TODO
 * @version: V1.0
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO converter(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());

        List<OrderDetail> orderDTOList = new ArrayList<>();
        try {
            orderDTOList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        }catch (Exception e){
            log.error("");
            throw new SellException(ResultEnum.CONVERTER_ERROR);
        }
        orderDTO.setOrderDetails(orderDTOList);
        return orderDTO;
    }
}
