package com.jiahanglee.journey.datacontroller;

import com.jiahanglee.journey.converter.OrderForm2OrderDTOConverter;
import com.jiahanglee.journey.dataservice.OrderService;
import com.jiahanglee.journey.dto.OrderDTO;
import com.jiahanglee.journey.enums.ResultEnum;
import com.jiahanglee.journey.exception.SellException;
import com.jiahanglee.journey.form.OrderForm;
import com.jiahanglee.journey.utils.ResultVoUtil;
import com.jiahanglee.journey.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/18 12:35
 * @Description: //TODO
 * @version: V1.0
 */
@Slf4j
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;
    //创建订单
    @PostMapping("/create")
    public ResultVo<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            log.error("");
            throw new SellException(bindingResult.getFieldError().getDefaultMessage(),ResultEnum.PARAM.getCode());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.converter(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetails())){
            log.error("");
            throw new SellException(ResultEnum.CART_NOT_NULL);
        }
        OrderDTO orderDTO1 = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",orderDTO1.getOrderId());

        return ResultVoUtil.success(map);
    }
    //订单列表
    //订单详情
    //取消订单
}
