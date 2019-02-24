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
        Optional<ProductInfo> optionalProductInfo = productInfoRepository.findById(productId);
        return optionalProductInfo.orElse(null);
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

    @Override
    public ProductInfo onSale(String productId) {
        Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(productId);
        if(!productInfoOptional.isPresent()) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if(productInfoOptional.get().getProductStatus().equals(ProductStatusEnum.UP.getCode())) {
            throw new SellException(ResultEnum.PRODUCT_UP);
        }
        productInfoOptional.get().setProductStatus(ProductStatusEnum.UP.getCode());
        return productInfoRepository.save(productInfoOptional.get());
    }

    @Override
    public ProductInfo offSale(String productId) {
        Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(productId);
        if(!productInfoOptional.isPresent()) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if(productInfoOptional.get().getProductStatus().equals(ProductStatusEnum.DOWN.getCode())) {
            throw new SellException(ResultEnum.PRODUCT_OFF);
        }
        productInfoOptional.get().setProductStatus(ProductStatusEnum.DOWN.getCode());
        return productInfoRepository.save(productInfoOptional.get());
    }
}
