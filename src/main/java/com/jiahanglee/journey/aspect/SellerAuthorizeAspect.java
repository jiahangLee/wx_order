package com.jiahanglee.journey.aspect;

import com.jiahanglee.journey.constant.CookieContant;
import com.jiahanglee.journey.constant.RedisContant;
import com.jiahanglee.journey.exception.SellerAuthorizeException;
import com.jiahanglee.journey.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/25 18:10
 * @Description: //TODO
 * @version: V1.0
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut(value = "execution(public * com.jiahanglee.journey.datacontroller.Seller*.*(..))" +
            "&& !execution(public * com.jiahanglee.journey.datacontroller.SellerUserController.*(..))")
    public void verify() {

    }

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Cookie cookie = CookieUtil.get(request, CookieContant.TOKEN);
        if (cookie == null) {
            log.warn("【登录校验】cookie查不到");
            throw new SellerAuthorizeException();

        } else {
            String token = stringRedisTemplate.opsForValue().get(String.format(RedisContant.TOKEN_PREFIX, cookie.getValue()));
            if (StringUtils.isEmpty(token)) {
                log.warn("【登录校验】redis中查不到token");
                throw new SellerAuthorizeException();
            }

        }
    }
}
