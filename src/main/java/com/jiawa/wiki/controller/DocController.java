/*
 * @Author       : SMou
 * @Date         : 2022-04-15 21:02:06
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-15 21:14:49
 * @Description  : 请填写简介
 */

package com.jiawa.wiki.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.jiawa.wiki.req.DocQueryReq;
import com.jiawa.wiki.req.DocSaveReq;
import com.jiawa.wiki.resp.CommonResp;
import com.jiawa.wiki.resp.DocQueryResp;
import com.jiawa.wiki.resp.PageResp;
import com.jiawa.wiki.service.DocService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doc")
public class DocController {

    @Resource
    private DocService docService;

    @GetMapping("/all")
    // @Valid 校验开启
    public CommonResp all(@Valid DocQueryReq req) {
        CommonResp<List<DocQueryResp>> resp = new CommonResp<>();
        List<DocQueryResp> list = docService.all(req);
        resp.setContent(list);
        return resp;
    }

    @GetMapping("/list")
    // @Valid 校验开启
    public CommonResp doc(@Valid DocQueryReq req) {
        CommonResp<PageResp<DocQueryResp>> resp = new CommonResp<>();
        PageResp<DocQueryResp> list = docService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody DocSaveReq req) {
        CommonResp resp = new CommonResp<>();
        docService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{idsStr}")
    public CommonResp delete(@PathVariable String idsStr) {
        CommonResp resp = new CommonResp<>();
        List<String> list = Arrays.asList(idsStr.split(","));
        docService.delete(list);
        return resp;
    }

}
