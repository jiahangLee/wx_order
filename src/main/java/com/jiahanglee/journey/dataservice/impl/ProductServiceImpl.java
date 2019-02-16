package com.jiahanglee.journey.dataservice.impl;

import com.jiahanglee.journey.dataobject.ProductInfo;
import com.jiahanglee.journey.dataservice.ProductService;
import com.jiahanglee.journey.enums.ProductStatusEnum;
import com.jiahanglee.journey.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 14:46
 * @Description: //TODO
 * @version: V1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findById(productId).get();
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll( pageable);
    }

    @Override
    public List<ProductInfo> findUpall() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }
}
