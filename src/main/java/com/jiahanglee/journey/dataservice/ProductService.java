package com.jiahanglee.journey.dataservice;

import com.jiahanglee.journey.dataobject.ProductInfo;
import com.jiahanglee.journey.dto.CatDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 14:43
 * @Description: //TODO
 * @version: V1.0
 */
public interface ProductService {

    ProductInfo findOne(String productId);
    Page<ProductInfo> findAll(Pageable pageable);
    List<ProductInfo> findUpall();

    ProductInfo save(ProductInfo productInfo);
    //加减库存
    void increaseStock(List<CatDTO> catDTOList);
    void decreaseStock(List<CatDTO> catDTOList);
    //上下架
    ProductInfo onSale(String productId);
    ProductInfo offSale(String productId);


}
