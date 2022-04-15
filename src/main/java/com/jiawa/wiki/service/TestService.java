/*
 * @Author : SMou
 * 
 * @Date : 2022-03-31 14:38:30
 * 
 * @LastEditors  : SMou
 * 
 * @LastEditTime : 2022-04-12 16:32:30
 * 
 * @Description : 请填写简介
 */

package com.jiawa.wiki.service;

import com.jiawa.wiki.domain.Test;
import com.jiawa.wiki.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public List<Test> list() {
        return testMapper.list();
    }
}
