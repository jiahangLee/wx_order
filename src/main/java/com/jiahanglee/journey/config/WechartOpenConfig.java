package com.jiahanglee.journey.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/24 23:06
 * @Description: //TODO
 * @version: V1.0
 */
@Component
public class WechartOpenConfig {
    @Autowired
    private WechatAccountConfig wechatAccountConfig;
    @Bean
    public WxMpService wxOpenService() {
        WxMpService wxOpenMpService = new WxMpServiceImpl();
        wxOpenMpService.setWxMpConfigStorage(wxOpenConfigStorage());
        return wxOpenMpService;
    }
    @Bean
    public WxMpConfigStorage wxOpenConfigStorage() {
        WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpInMemoryConfigStorage.setAppId(wechatAccountConfig.getOpenAppId());
        wxMpInMemoryConfigStorage.setSecret(wechatAccountConfig.getOpenAppSecret());
        return wxMpInMemoryConfigStorage;
    }
}
