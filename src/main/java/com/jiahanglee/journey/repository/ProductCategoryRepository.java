package com.jiahanglee.journey.repository;

import com.jiahanglee.journey.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 10:43
 * @Description: //TODO
 * @version: V1.0
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
