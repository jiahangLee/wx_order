package com.jiahanglee.journey.repository;

import com.jiahanglee.journey.dataobject.ProductInfo;
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
 * @Date: 2019/2/16 14:02
 * @Description: //TODO
 * @version: V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("小炒肉");
        productInfo.setProductPrice(new BigDecimal(18.2));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃的");
        productInfo.setProductIcon("http://xxx.png");
        productInfo.setCategoryType(2);

        ProductInfo productInfo1 = productInfoRepository.save(productInfo);
        assertNotEquals(0,productInfo1);
    }
    @Test
    public void findByProductStatus() {

        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);
        assertNotEquals(0,productInfoList);
    }
}