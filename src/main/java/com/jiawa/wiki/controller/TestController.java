/*
 * @Author : SMou
 * 
 * @Date : 2022-03-29 15:04:01
 * 
 * @LastEditors  : SMou
 * 
 * @LastEditTime : 2022-03-31 14:06:44
 * 
 * @Description : 请填写简介
 */
package com.jiawa.wiki.controller;


import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${test.hello}")
    private String testHello;


    @GetMapping("/hello")
    public String hello() {
        return "Hello World!"+testHello;
    }

    @PostMapping("/hello/post")
    public String helloPost(String name) {
        return "Hello World Post." + name;
    }
}
