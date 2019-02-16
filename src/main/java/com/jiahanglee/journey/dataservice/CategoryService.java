package com.jiahanglee.journey.dataservice;

import com.jiahanglee.journey.dataobject.ProductCategory;

import java.util.List;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 13:20
 * @Description: //TODO
 * @version: V1.0
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}
