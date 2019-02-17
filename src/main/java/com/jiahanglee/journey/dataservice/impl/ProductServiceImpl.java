package com.jiahanglee.journey.dataservice.impl;

import com.jiahanglee.journey.dataobject.ProductInfo;
import com.jiahanglee.journey.dataservice.ProductService;
import com.jiahanglee.journey.dto.CatDTO;
import com.jiahanglee.journey.enums.ProductStatusEnum;
import com.jiahanglee.journey.enums.ResultEnum;
import com.jiahanglee.journey.exception.SellException;
import com.jiahanglee.journey.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void increaseStock(List<CatDTO> catDTOList) {
        for(CatDTO catDTO:catDTOList){
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(catDTO.getProductId());
            if(productInfoOptional.isPresent()){
                ProductInfo productInfo = productInfoOptional.get();
                Integer result = productInfo.getProductStock() + catDTO.getProductQuantity();
                productInfo.setProductStock(result);
                productInfoRepository.save(productInfo);
            }else{
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CatDTO> catDTOList) {
        for(CatDTO catDTO:catDTOList){
            ProductInfo productInfo = productInfoRepository.findById(catDTO.getProductId()).get();
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - catDTO.getProductQuantity();
            if(result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
