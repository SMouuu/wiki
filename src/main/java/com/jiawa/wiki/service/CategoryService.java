/*
 * @Author       : SMou
 * @Date         : 2022-04-15 20:19:30
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-15 20:19:47
 * @Description  : 请填写简介
 */
/*
 * @Author : SMou
 * 
 * @Date : 2022-03-31 14:38:30
 * 
 * @LastEditors  : SMou
 * 
 * @LastEditTime : 2022-04-15 17:14:06
 * 
 * @Description : 请填写简介
 */

package com.jiawa.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.wiki.domain.Category;
import com.jiawa.wiki.domain.CategoryExample;
import com.jiawa.wiki.mapper.CategoryMapper;
import com.jiawa.wiki.req.CategoryQueryReq;
import com.jiawa.wiki.req.CategorySaveReq;
import com.jiawa.wiki.resp.CategoryQueryResp;
import com.jiawa.wiki.resp.PageResp;
import com.jiawa.wiki.util.CopyUtil;
import com.jiawa.wiki.util.SnowFlake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private SnowFlake snowFlake;

    public PageResp<CategoryQueryResp> list(CategoryQueryReq req) {

        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);

        PageInfo<Category> pageinfo = new PageInfo<>(categoryList);
        LOG.info("总行数:{}", pageinfo.getTotal());
        LOG.info("总页数:{}", pageinfo.getPages());
        // List<CategoryResp> respList = new ArrayList<>();
        // for (Category category : categoryList) {
        // CategoryResp categoryResp = new CategoryResp();
        // BeanUtils.copyProperties(category, categoryResp);
        // respList.add(categoryResp);
        // }

        // 列表复制
        List<CategoryQueryResp> list = CopyUtil.copyList(categoryList, CategoryQueryResp.class);

        PageResp<CategoryQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageinfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    // 保存
    public void save(CategorySaveReq req) {
        Category category = CopyUtil.copy(req, Category.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            // 新增
            category.setId(snowFlake.nextId());
            categoryMapper.insert(category);
        } else {
            // 更新
            categoryMapper.updateByPrimaryKey(category);
        }

    }

    // 删除
    public void delete(Long id) {
        categoryMapper.deleteByPrimaryKey(id);
    }
}
