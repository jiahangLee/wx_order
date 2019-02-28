package com.jiahanglee.journey.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Auther: jiahangLee
 * @Date: 2019/2/28 22:32
 * @Description: //TODO
 * @version: V1.0
 */
@Component
@Slf4j
@ServerEndpoint("/webSocket")
public class WebSocket {

    private Session session;
    private static CopyOnWriteArraySet<WebSocket> webSocket = new CopyOnWriteArraySet<>();
    @OnOpen
    public  void opOpen(Session session) {
        this.session = session;
        webSocket.add(this);
        log.info("【webSocket消息】有新的连接，总数{}",webSocket.size());
    }
    @OnClose
    public  void onClone(){
        webSocket.remove(this);
        log.info("【webSocket消息】连接断开，总数{}",webSocket.size());
    }
    @OnMessage
    public void OnMessage(String message) {
        log.info("【webSocket消息】收到客户端的消息{}",message);
    }
    public void sendMessage(String message) {
        for(WebSocket webSocket: webSocket) {
            log.info("【webSocket消息】广播消息，message={}",message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
