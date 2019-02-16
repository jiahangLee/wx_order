package com.jiahanglee.journey.dataservice.impl;

import com.jiahanglee.journey.dataobject.OrderDetail;
import com.jiahanglee.journey.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

        log.info("[dingding]result={}",orderDTO1);
        assertNotNull(orderDTO1);

    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void pay() {
    }
}