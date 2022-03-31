/*
 * @Author : SMou
 * 
 * @Date : 2022-03-29 15:04:01
 * 
 * @LastEditors  : SMou
 * 
 * @LastEditTime : 2022-03-31 15:47:03
 * 
 * @Description : 请填写简介
 */
package com.jiawa.wiki.controller;

import java.util.List;

import javax.annotation.Resource;

import com.jiawa.wiki.domain.Demo;
import com.jiawa.wiki.service.DemoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private DemoService demoService;

    @GetMapping("/list")
    public List<Demo> demo() {
        return demoService.list();
    }
}
