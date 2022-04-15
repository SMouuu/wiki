/*
 * @Author : SMou
 * 
 * @Date : 2022-03-31 14:38:30
 * 
 * @LastEditors  : SMou
 * 
 * @LastEditTime : 2022-04-12 16:27:36
 * 
 * @Description : 请填写简介
 */

package com.jiawa.wiki.service;

import com.jiawa.wiki.domain.Demo;
import com.jiawa.wiki.mapper.DemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService {

    @Resource
    private DemoMapper DemoMapper;

    public List<Demo> list() {
        return DemoMapper.selectByExample(null);
    }
}
