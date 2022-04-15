/*
 * @Author       : SMou
 * @Date         : 2022-04-15 21:59:25
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-15 22:22:47
 * @Description  : 请填写简介
 */

package com.jiawa.wiki.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.jiawa.wiki.req.User1QueryReq;
import com.jiawa.wiki.req.User1SaveReq;
import com.jiawa.wiki.resp.CommonResp;
import com.jiawa.wiki.resp.PageResp;
import com.jiawa.wiki.resp.User1QueryResp;
import com.jiawa.wiki.service.User1Service;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class User1Controller {

    @Resource
    private User1Service userService;

    @GetMapping("/list")
    // @Valid 校验开启
    public CommonResp list(@Valid User1QueryReq req) {
        CommonResp<PageResp<User1QueryResp>> resp = new CommonResp<>();
        PageResp<User1QueryResp> list = userService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody User1SaveReq req) {
        CommonResp resp = new CommonResp<>();
        userService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        userService.delete(id);
        return resp;
    }

}
