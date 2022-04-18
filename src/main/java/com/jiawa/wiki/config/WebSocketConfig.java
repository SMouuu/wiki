/*
 * @Author       : SMou
 * @Date         : 2022-04-18 17:04:06
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-18 17:04:06
 * @Description  : 请填写简介
 */
package com.jiawa.wiki.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
