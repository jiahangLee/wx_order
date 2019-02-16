package com.jiahanglee.journey.repository;

import com.jiahanglee.journey.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 10:46
 * @Description: //TODO
 * @version: V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest(){
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(1);
        System.out.println(productCategory.toString());
    }

    @Test
//    @Transactional // 不保存数据库
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("女人最爱",6);
        productCategoryRepository.save(productCategory);
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void update(){
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(4);
        productCategory.get().setCategoryType(11);
        productCategoryRepository.save(productCategory.get());
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(2,4);

        List<ProductCategory> result = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(0,result.size());
    }
}