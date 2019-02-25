package com.jiahanglee.journey.datacontroller;

import com.jiahanglee.journey.config.ProjectUrl;
import com.jiahanglee.journey.constant.CookieContant;
import com.jiahanglee.journey.constant.RedisContant;
import com.jiahanglee.journey.dataobject.SellerInfo;
import com.jiahanglee.journey.dataservice.SellerService;
import com.jiahanglee.journey.enums.ResultEnum;
import com.jiahanglee.journey.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/25 12:29
 * @Description: //TODO
 * @version: V1.0
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ProjectUrl projectUrl;
    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid")String openid,
                      HttpServletResponse response,
                      Map<String,Object> map) {

        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        if(sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FALSE);
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        String token = UUID.randomUUID().toString();
        Integer expire = RedisContant.EXPIRE;
        stringRedisTemplate.opsForValue().set(String.format(RedisContant.TOKEN_PREFIX,token),openid,expire, TimeUnit.SECONDS);

        CookieUtil.set(response, CookieContant.TOKEN,token,expire);

        return new ModelAndView("redirect:"+ projectUrl.sell+"/sell/seller/order/list");

    }
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletResponse response,
                               HttpServletRequest request,
                               Map<String,Object> map) {

        Cookie cookie = CookieUtil.get(request,CookieContant.TOKEN);
        if(cookie !=  null) {
            stringRedisTemplate.opsForValue().getOperations().delete(String.format(RedisContant.TOKEN_PREFIX,cookie.getValue()));
            CookieUtil.set(response,CookieContant.TOKEN,null,0);
        }
        map.put("msg",ResultEnum.LOGIN_SUCCESS);
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }
}
