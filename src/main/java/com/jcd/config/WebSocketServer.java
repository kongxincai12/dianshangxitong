package com.jcd.config;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/websocket/{clientId}")
public class WebSocketServer {
    public static ConcurrentHashMap<String, WebSocketServer> clients = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
    private Session session;
    private String clientId;

    /*@OnOpen
    public void onOpen(Session session, @PathParam("clientId") String clientId) {
        this.session = session;
        this.clientId = clientId;
        clients.put(clientId, this);
        map.put("userId",clientId);

        System.out.println("客户端连接：" + clientId);
        System.out.println("客户端【" + clientId + "】连接成功，当前在线人数：" + clients.size());
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("收到消息：" + message);
    }

    @OnClose
    public void onClose() {
        clients.remove(clientId);
        System.out.println("客户端【" + clientId + "】断开连接，当前在线人数：" + clients.size());
    }

    @OnError
    public void onError(Throwable e) {
        // 忽略 EOFException（客户端断开）
        if (e instanceof java.io.EOFException) {
            System.out.println("客户端断开连接(EOF)：" + clientId);
            return;
        }
        e.printStackTrace();
    }

    // 发送给单个客户端
    public static void sendToClient(String clientId, String message) {
        try {
            clients.get(clientId).session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 群发
    public static void sendToAll(String message) {
        for (WebSocketServer client : clients.values()) {
            try {
                client.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
}
