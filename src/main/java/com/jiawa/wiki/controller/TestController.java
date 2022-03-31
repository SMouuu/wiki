/*
 * @Author : SMou
 * 
 * @Date : 2022-03-29 15:04:01
 * 
 * @LastEditors  : SMou
 * 
 * @LastEditTime : 2022-03-31 15:00:46
 * 
 * @Description : 请填写简介
 */
package com.jiawa.wiki.controller;

import java.util.List;

import javax.annotation.Resource;

import com.jiawa.wiki.domain.Test;
import com.jiawa.wiki.service.TestService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("/hello/post")
    public String helloPost(String name) {
        return "Hello World Post." + name;
    }

    @GetMapping("/test/list")
    public List<Test> test() {
        return testService.list();
    }
}
