/*
 * @Author : SMou
 * 
 * @Date : 2022-03-29 15:04:01
 * 
 * @LastEditors  : SMou
 * 
 * @LastEditTime : 2022-03-31 14:10:22
 * 
 * @Description : 请填写简介
 */
package com.jiawa.wiki.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("/hello/post")
    public String helloPost(String name) {
        return "Hello World Post." + name;
    }
}
