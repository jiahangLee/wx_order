package com.jiahanglee.journey.datacontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/20 12:32
 * @Description: //TODO
 * @version: V1.0
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam(value = "code",required = false) String code,
                     @RequestParam(value = "state",required = false) String state){
        log.info("进入auth方法");
        log.info("codeoooooo={}",code);
        // codeoooooo=061YpJDW0pPgV22bGcEW0fJGDW0YpJD4
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxe0ce3eb470a3e06a&secret=b7411b113cc0ddbb7b5c8883db86f432&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url,String.class);
        log.info("result={}",response);
        // "openid":"ot-dr1PQWsoL2xjbjRyrDikZnhQY"
    }
}
