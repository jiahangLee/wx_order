package com.jiahanglee.journey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/28 22:31
 * @Description: //TODO
 * @version: V1.0
 */
@Component
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
