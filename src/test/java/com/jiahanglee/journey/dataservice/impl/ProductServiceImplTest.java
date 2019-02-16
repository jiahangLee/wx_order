package com.jiahanglee.journey.dataservice.impl;

import com.jiahanglee.journey.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 15:04
 * @Description: //TODO
 * @version: V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("123456");
        assertNotNull(productInfo);
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> productInfoList = productService.findAll(pageRequest);
        System.out.println(productInfoList.getTotalElements());
    }

    @Test
    public void findUpall() {
        List<ProductInfo> productInfoList = productService.findUpall();
        assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void save() {

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("12345678");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(13.9));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);
        productInfo.setProductDescription("皮皮虾我们走");
        productInfo.setProductIcon("http://xxx.png");
        productInfo.setCategoryType(11);

        ProductInfo productInfo1 = productService.save(productInfo);
        assertNotEquals(0,productInfo1);
    }
}