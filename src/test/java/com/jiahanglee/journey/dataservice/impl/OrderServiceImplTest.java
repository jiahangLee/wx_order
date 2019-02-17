package com.jiahanglee.journey.dataservice.impl;

import com.jiahanglee.journey.dataobject.OrderDetail;
import com.jiahanglee.journey.dto.OrderDTO;
import com.jiahanglee.journey.enums.OrderStatusEnum;
import com.jiahanglee.journey.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 23:02
 * @Description: //TODO
 * @version: V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;
    private String buyerOpenid = "110110000";
    @Test
    public void create() {

        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("12345678");
        orderDetail.setProductQuantity(3);
        orderDetails.add(orderDetail);

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("小明");
        orderDTO.setBuyerAddress("余杭区");
        orderDTO.setBuyerPhone("17610198005");
        orderDTO.setBuyerOpenid(buyerOpenid);
        orderDTO.setOrderDetails(orderDetails);
        OrderDTO orderDTO1= orderService.create(orderDTO);

        log.info("【创建订单】result={}",orderDTO1);
        assertNotNull(orderDTO1);

    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne("1550331657937170244");
        log.info("【查询订单】result={}",orderDTO);
        assertEquals("1550331657937170244",orderDTO.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOS = orderService.findList("110110",request);
        assertNotEquals(0,orderDTOS);
    }

    @Test
//    @Transactional 测试中不能加事务
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne("1550331657937170244");
        OrderDTO result = orderService.cancel(orderDTO);
        assertEquals(result.getOrderStatus(), OrderStatusEnum.CANCEL.getCode());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne("1550331794364309886");
        OrderDTO result = orderService.finish(orderDTO);
        assertEquals(result.getOrderStatus(), OrderStatusEnum.FINISHED.getCode());

    }

    @Test
    public void pay() {
        OrderDTO orderDTO = orderService.findOne("1550331329065893359");
        OrderDTO result = orderService.pay(orderDTO);
        assertEquals(result.getPayStatus(), PayStatusEnum.SUCCESS.getCode());
    }
}