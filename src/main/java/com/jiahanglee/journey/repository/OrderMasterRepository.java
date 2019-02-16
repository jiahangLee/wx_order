package com.jiahanglee.journey.repository;

import com.jiahanglee.journey.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 21:06
 * @Description: //TODO
 * @version: V1.0
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    Page<OrderMaster> findByBuyerOpenid(String openid, Pageable pageable);

}
