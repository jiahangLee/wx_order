package com.jiahanglee.journey.datacontroller;

import com.jiahanglee.journey.dataservice.OrderService;
import com.jiahanglee.journey.dto.OrderDTO;
import com.jiahanglee.journey.enums.ResultEnum;
import com.jiahanglee.journey.exception.SellException;
import com.jiahanglee.journey.services.PayService;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/20 20:32
 * @Description: //TODO
 * @version: V1.0
 */
@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(
            @RequestParam("orderId") String orderId,
            @RequestParam("returnUrl") String returnUrl,
            Map<String, Object> map
    ) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            log.error("");
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        PayResponse payResponse = payService.create(orderDTO);
        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);
        return new ModelAndView("pay/create", map);
    }
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyDate) {

        payService.notify(notifyDate);
        return new ModelAndView("pay/success");
    }
}
