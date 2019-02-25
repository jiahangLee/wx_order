package com.jiahanglee.journey.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/25 11:53
 * @Description: //TODO
 * @version: V1.0
 */
@Data
@ConfigurationProperties(prefix = "project-config")
@Component
public class ProjectUrl {

    public String wechatMpAuthorize;
    public String wechatOpenAuthorize;
    public String sell;
}
