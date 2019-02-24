package com.jiahanglee.journey.repository;

import com.jiahanglee.journey.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/24 22:22
 * @Description: //TODO
 * @version: V1.0
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {
    SellerInfo findByOpenid(String openid);
}
