package com.jiahanglee.journey.handler;

import com.jiahanglee.journey.config.ProjectUrl;
import com.jiahanglee.journey.exception.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/25 18:30
 * @Description: //TODO
 * @version: V1.0
 */
@ControllerAdvice
public class SellerExceptionHandler {

    @Autowired
    private ProjectUrl projectUrl;
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:".concat("https://open.weixin.qq.com/connect/qrconnect?appid=wx6ad144e54af67d87&redirect_uri=http%3a%2f%2fsell.springboot.cn%2fsell%2fqr%2foTgZpwZOfSnmkCFLYjojjl33_Cbo&response_type=code&scope=snsapi_login&state=http%3a%2f%2fjiahanglee.natapp1.cc%2fsell%2fwechat%2fqrUserInfo"));
    }
    //https://open.weixin.qq.com/connect/qrconnect?
    // appid=wx6ad144e54af67d87
    // &redirect_uri=http%3a%2f%2fsell.springboot.cn%2fsell%2fqr%2foTgZpwZOfSnmkCFLYjojjl33_Cbo&response_type=code
    // &scope=snsapi_login
    // &state=http%3a%2f%2fjiahanglee.natapp1.cc%2fsell%2fwechat%2fqrUserInfo
}
