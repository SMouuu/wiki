/*
 * @Author : SMou
 * 
 * @Date : 2022-03-31 14:38:30
 * 
 * @LastEditors  : SMou
 * 
 * @LastEditTime : 2022-03-31 16:06:55
 * 
 * @Description : 请填写简介
 */

package com.jiawa.wiki.service;

import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<Ebook> list() {
        return ebookMapper.selectByExample(null);
    }
}
