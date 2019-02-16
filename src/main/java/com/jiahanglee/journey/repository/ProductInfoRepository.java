package com.jiahanglee.journey.repository;

import com.jiahanglee.journey.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 13:59
 * @Description: //TODO
 * @version: V1.0
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
