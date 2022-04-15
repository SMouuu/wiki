/*
 * @Author       : SMou
 * @Date         : 2022-04-15 22:00:22
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-15 22:21:26
 * @Description  : 请填写简介
 */

package com.jiawa.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.wiki.domain.User1;
import com.jiawa.wiki.domain.User1Example;
import com.jiawa.wiki.mapper.User1Mapper;
import com.jiawa.wiki.req.User1QueryReq;
import com.jiawa.wiki.req.User1SaveReq;
import com.jiawa.wiki.req.User1QueryReq;
import com.jiawa.wiki.resp.User1QueryResp;
import com.jiawa.wiki.resp.PageResp;
import com.jiawa.wiki.util.CopyUtil;
import com.jiawa.wiki.util.SnowFlake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

import java.util.List;

@Service
public class User1Service {
    private static final Logger LOG = LoggerFactory.getLogger(User1Service.class);

    @Resource
    private User1Mapper user1Mapper;

    @Resource
    private SnowFlake snowFlake;

    public PageResp<User1QueryResp> list(User1QueryReq req) {

        User1Example user1Example = new User1Example();
        User1Example.Criteria criteria = user1Example.createCriteria();
        if (!ObjectUtils.isEmpty(req.getLoginName())) {
            criteria.andLoginNameEqualTo(req.getLoginName());
        }
        PageHelper.startPage(req.getPage(), req.getSize());
        List<User1> user1List = user1Mapper.selectByExample(user1Example);

        PageInfo<User1> pageinfo = new PageInfo<>(user1List);
        LOG.info("总行数:{}", pageinfo.getTotal());
        LOG.info("总页数:{}", pageinfo.getPages());
        // List<User1Resp> respList = new ArrayList<>();
        // for (User1 user1 : user1List) {
        // User1Resp user1Resp = new User1Resp();
        // BeanUtils.copyProperties(user1, user1Resp);
        // respList.add(user1Resp);
        // }

        // 列表复制
        List<User1QueryResp> list = CopyUtil.copyList(user1List, User1QueryResp.class);

        PageResp<User1QueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageinfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    // 保存
    public void save(User1SaveReq req) {
        User1 user1 = CopyUtil.copy(req, User1.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            // 新增
            user1.setId(snowFlake.nextId());
            user1Mapper.insert(user1);
        } else {
            // 更新
            user1Mapper.updateByPrimaryKey(user1);
        }

    }

    // 删除
    public void delete(Long id) {
        user1Mapper.deleteByPrimaryKey(id);
    }
}
