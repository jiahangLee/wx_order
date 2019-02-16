package com.jiahanglee.journey.datacontroller;

import com.jiahanglee.journey.dataobject.ProductCategory;
import com.jiahanglee.journey.dataobject.ProductInfo;
import com.jiahanglee.journey.dataservice.CategoryService;
import com.jiahanglee.journey.dataservice.ProductService;
import com.jiahanglee.journey.utils.ResultVoUtil;
import com.jiahanglee.journey.vo.ProductInfoVo;
import com.jiahanglee.journey.vo.ProductVo;
import com.jiahanglee.journey.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 15:30
 * @Description: //TODO
 * @version: V1.0
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVo list() {

        List<ProductInfo> productInfoList = productService.findUpall();

        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductVo> productVos = new ArrayList<>();
        for (ProductCategory productCategory : productCategories) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVo> productInfoList1 = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoList1.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoList1);
            productVos.add(productVo);
        }

        return ResultVoUtil.success(productVos);
    }
}
