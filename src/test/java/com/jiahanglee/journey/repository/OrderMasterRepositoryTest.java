package com.jiahanglee.journey.repository;

import com.jiahanglee.journey.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 21:14
 * @Description: //TODO
 * @version: V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    private String ORDERID = "110110";
    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12345678");
        orderMaster.setBuyerName("jiahanglee");
        orderMaster.setBuyerPhone(ORDERID);
        orderMaster.setBuyerAddress("余杭区");
        orderMaster.setBuyerOpenid("520520");
        orderMaster.setOrderAmount(new BigDecimal(19.6));

        OrderMaster orderMaster1 = orderMasterRepository.save(orderMaster);
        assertNotNull(orderMaster1);
    }
    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderMaster> orderMasters = orderMasterRepository.findByBuyerOpenid("123456",pageRequest);
        assertNotEquals(0,orderMasters);

    }
}