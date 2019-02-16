package com.jiahanglee.journey.repository;

import com.jiahanglee.journey.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 21:30
 * @Description: //TODO
 * @version: V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("11111110");
        orderDetail.setProductName("小馒头");
        orderDetail.setProductPrice(new BigDecimal(12.5));
        orderDetail.setDetailId("1234567890");
        orderDetail.setProductId("1111110");
        orderDetail.setProductQuantity(2);
        orderDetail.setProductIcon("http://xxx.png");

        OrderDetail orderDetail1 = orderDetailRepository.save(orderDetail);
        assertNotNull(orderDetail);
    }
    @Test
    public void findByOrderId() {

        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId("11111110");
        assertNotEquals(0,orderDetails.size());
    }
}