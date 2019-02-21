package com.jiahanglee.journey.services.impl;

import com.jiahanglee.journey.dataservice.OrderService;
import com.jiahanglee.journey.dto.OrderDTO;
import com.jiahanglee.journey.services.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/20 20:54
 * @Description: //TODO
 * @version: V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;
    @Autowired
    private OrderService orderService;
    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("1550487365779596736");
        payService.create(orderDTO);
    }

    @Test
    public void create1() {
    }


    @Test
    public void refund() {

        OrderDTO orderDTO = orderService.findOne("1550487104154674813");
        payService.refund(orderDTO);
    }
}