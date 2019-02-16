package com.jiahanglee.journey.repository;

import com.jiahanglee.journey.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 21:10
 * @Description: //TODO
 * @version: V1.0
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String orderId);
}
