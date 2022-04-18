/*
 * @Author : SMou
 * 
 * @Date : 2022-04-18 17:35:45
 * 
 * @LastEditors  : SMou
 * 
 * @LastEditTime : 2022-04-18 17:50:27
 * 
 * @Description : 为了异步化，重新生成的一个类
 */
package com.jiawa.wiki.service;

import javax.annotation.Resource;

import com.jiawa.wiki.websocket.WebSocketServer;

import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class WsService {

    @Resource
    private WebSocketServer webSocketServer;

    @Async
    public void sendInfo(String message, String logId) {
        MDC.put("LOG_ID", logId);
        webSocketServer.sendInfo(message);
    }
}
