package com.jiahanglee.journey.datacontroller;

import com.jiahanglee.journey.vo.ProductInfoVo;
import com.jiahanglee.journey.vo.ProductVo;
import com.jiahanglee.journey.vo.ResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/16 15:30
 * @Description: //TODO
 * @version: V1.0
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @GetMapping("/list")
    public ResultVo list(){
       ResultVo resultVo = new ResultVo();
       ProductInfoVo productInfoVo = new ProductInfoVo();
       ProductVo productVo = new ProductVo();

       productVo.setProductInfoVoList(Arrays.asList(productInfoVo));
       resultVo.setData(Arrays.asList(productVo));
       resultVo.setCode(0);
       resultVo.setMsg("成功");


       return resultVo;
    }
}
