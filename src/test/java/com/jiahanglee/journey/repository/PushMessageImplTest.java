package com.jiahanglee.journey.repository;

import com.jiahanglee.journey.dataservice.OrderService;
import com.jiahanglee.journey.dto.OrderDTO;
import com.jiahanglee.journey.services.impl.PushMessageImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/25 19:28
 * @Description: //TODO
 * @version: V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageImplTest {

    @Autowired
    private PushMessageImpl pushMessage;
    @Autowired
    private OrderService orderService;
    @Test
    public void orderStatus() {
        OrderDTO orderDTO = orderService.findOne("1550748706829196867");
        pushMessage.orderStatus(orderDTO);
    }
}