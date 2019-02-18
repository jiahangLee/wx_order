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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public ResultVo create(@Valid OrderForm orderForm, BindingResult bindingResult) {

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
    @GetMapping("/list")
    public ResultVo List(
            @RequestParam("openid") String openid,
            @RequestParam(value = "page",defaultValue = "0") Integer page,
            @RequestParam(value = "size",defaultValue = "5") Integer size
    ){
        if(StringUtils.isEmpty(openid)){
            log.error("");
//            throw new SellException()
        }
        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> orderDTOS = orderService.findList(openid,request);
        return ResultVoUtil.success(orderDTOS.getContent());
    }
    //订单详情
    @GetMapping("/detail")
    public ResultVo detail(
            @RequestParam(value = "openid",required = false) String openid,
            @RequestParam("orderId") String orderId
    ){
        // 检验openid
        OrderDTO orderDTO = orderService.findOne(orderId);
        return ResultVoUtil.success(orderDTO);
    }
    //取消订单
    @PostMapping("/cancel")
    public ResultVo cancel(
            @RequestParam(value = "openid",required = false)String openid,
            @RequestParam(value= "orderId")String orderId
    ){
        OrderDTO orderDTO = orderService.findOne(orderId);
        orderService.cancel(orderDTO);
        return ResultVoUtil.success(orderDTO);
    }
}
