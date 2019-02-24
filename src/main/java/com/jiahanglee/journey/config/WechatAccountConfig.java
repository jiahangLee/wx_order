package com.jiahanglee.journey.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/20 14:39
 * @Description: //TODO
 * @version: V1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String myAppId;
    private String myAppSecret;

    private String openAppId;
    private String openAppSecret;

    private String mchId;
    private String mchKey;
    private String keyPath;

    private String notifyUrl;
}
