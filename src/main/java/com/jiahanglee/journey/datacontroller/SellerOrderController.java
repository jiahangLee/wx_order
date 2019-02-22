package com.jiahanglee.journey.datacontroller;

import com.jiahanglee.journey.dataservice.OrderService;
import com.jiahanglee.journey.dto.OrderDTO;
import com.jiahanglee.journey.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/22 11:11
 * @Description: //TODO
 * @version: V1.0
 */
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderService orderService;
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "5") Integer size,
                             Map<String,Object> map) {
        PageRequest request = new PageRequest(page-1,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage",orderDTOPage);
        map.put("size",size);
        map.put("currentPage",page);
        return new ModelAndView("order/list",map);
    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId")String orderId,Map<String,Object> map) {
        try{
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        }catch (SellException e) {
            map.put("msg","订单找不到");
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
//        if(orderDTO == null) {
//            log.error("");
//
//        }
        map.put("msg","成功");
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success");
    }
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId")String orderId,Map<String,Object> map) {
        OrderDTO orderDTO ;
        try {
            orderDTO = orderService.findOne(orderId);
        }catch (SellException e) {
            map.put("msg","订单完结失败");
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("orderDTO",orderDTO);
        return new ModelAndView("order/detail",map);

    }
    @GetMapping("/finish")
    public ModelAndView finished(@RequestParam("orderId")String orderId,Map<String,Object> map) {

        OrderDTO orderDTO ;
        try {
            orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        }catch (SellException e) {
            map.put("msg","详情找不到");
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg","成功");
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success");
    }
}
