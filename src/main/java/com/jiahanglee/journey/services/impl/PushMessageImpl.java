package com.jiahanglee.journey.services.impl;

import com.jiahanglee.journey.dto.OrderDTO;
import com.jiahanglee.journey.services.PushMessage;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/25 19:09
 * @Description: //TODO
 * @version: V1.0
 */
@Service
@Slf4j
public class PushMessageImpl implements PushMessage {
    @Autowired
    private WxMpService wxMpService;
    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage wxMpTemplateMessage = new WxMpTemplateMessage();

        wxMpTemplateMessage.setTemplateId("YghqWHgS8LR2ev9GqN1aneGpt7AYIF-Hi6LSlqGaook");
        wxMpTemplateMessage.setToUser("ot-dr1PQWsoL2xjbjRyrDikZnhQY");
        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first","亲，记得收获"),
                new WxMpTemplateData("keyword1","微信点餐"),
                new WxMpTemplateData("keyword2","亲，记得收获"),
                new WxMpTemplateData("keyword3","亲，记得收获"),
                new WxMpTemplateData("keyword4","亲，记得收获"),
                new WxMpTemplateData("keyword5","亲，记得收获"),
                new WxMpTemplateData("remark","欢迎光临")
        );

        wxMpTemplateMessage.setData(data);

        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(wxMpTemplateMessage);
        }catch (WxErrorException e) {
            log.warn("【模板微信消息发送失败，{}",e);
        }
    }
}
