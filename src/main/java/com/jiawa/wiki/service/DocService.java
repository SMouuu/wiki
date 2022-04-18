/*
 * @Author       : SMou
 * @Date         : 2022-04-15 21:03:26
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-18 18:10:21
 * @Description  : 请填写简介
 */

package com.jiawa.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.wiki.domain.Content;
import com.jiawa.wiki.domain.Doc;
import com.jiawa.wiki.domain.DocExample;
import com.jiawa.wiki.exception.BusinessException;
import com.jiawa.wiki.exception.BusinessExceptionCode;
import com.jiawa.wiki.mapper.ContentMapper;
import com.jiawa.wiki.mapper.DocMapper;
import com.jiawa.wiki.mapper.DocMapperCust;
import com.jiawa.wiki.req.DocQueryReq;
import com.jiawa.wiki.req.DocSaveReq;
import com.jiawa.wiki.resp.DocQueryResp;
import com.jiawa.wiki.resp.PageResp;
import com.jiawa.wiki.util.CopyUtil;
import com.jiawa.wiki.util.RedisUtil;
import com.jiawa.wiki.util.RequestContext;
import com.jiawa.wiki.util.SnowFlake;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

import java.util.List;

@Service
public class DocService {
    private static final Logger LOG = LoggerFactory.getLogger(DocService.class);

    @Resource
    private DocMapper docMapper;

    @Resource
    private DocMapperCust docMapperCust;

    @Resource
    private ContentMapper contentMapper;

    @Resource
    private SnowFlake snowFlake;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private WsService wsService;

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public List<DocQueryResp> all(Long EbookId) {

        DocExample docExample = new DocExample();
        docExample.createCriteria().andEbookIdEqualTo(EbookId);
        docExample.setOrderByClause("sort asc");
        List<Doc> docList = docMapper.selectByExample(docExample);
        // 列表复制
        List<DocQueryResp> list = CopyUtil.copyList(docList, DocQueryResp.class);
        return list;
    }

    public PageResp<DocQueryResp> list(DocQueryReq req) {

        DocExample docExample = new DocExample();
        docExample.setOrderByClause("sort asc");
        DocExample.Criteria criteria = docExample.createCriteria();
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Doc> docList = docMapper.selectByExample(docExample);

        PageInfo<Doc> pageinfo = new PageInfo<>(docList);
        LOG.info("总行数:{}", pageinfo.getTotal());
        LOG.info("总页数:{}", pageinfo.getPages());
        // List<DocResp> respList = new ArrayList<>();
        // for (Doc doc : docList) {
        // DocResp docResp = new DocResp();
        // BeanUtils.copyProperties(doc, docResp);
        // respList.add(docResp);
        // }

        // 列表复制
        List<DocQueryResp> list = CopyUtil.copyList(docList, DocQueryResp.class);

        PageResp<DocQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageinfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }

    // 保存
    // 事务注解
    @Transactional
    public void save(DocSaveReq req) {
        Doc doc = CopyUtil.copy(req, Doc.class);
        Content content = CopyUtil.copy(req, Content.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            // 新增
            doc.setId(snowFlake.nextId());
            doc.setViewCount(0);
            doc.setVoteCount(0);
            docMapper.insert(doc);

            content.setId(doc.getId());
            contentMapper.insert(content);
        } else {
            // 更新
            docMapper.updateByPrimaryKey(doc);
            // 带大字段
            contentMapper.updateByPrimaryKeyWithBLOBs(content);
        }

    }

    // 删除
    public void delete(Long id) {
        docMapper.deleteByPrimaryKey(id);
    }

    // 删除
    public void delete(List<String> ids) {
        DocExample docExample = new DocExample();
        DocExample.Criteria criteria = docExample.createCriteria();
        criteria.andIdIn(ids);
        docMapper.deleteByExample(docExample);
    }

    public String findContent(Long id) {
        Content content = contentMapper.selectByPrimaryKey(id);
        // 文档阅读数+1
        docMapperCust.increaseViewCount(id);
        if (ObjectUtils.isEmpty(content)) {
            return "";
        } else {
            return content.getContent();
        }
    }

    // 点赞
    public void vote(Long id) {
        // docMapperCust.increaseVoteCount(id);
        // 远程ip+doc.id作为key,24小时之内不能重复
        String ip = RequestContext.getRemoteAddr();
        if (redisUtil.validateRepeat("DOC_VOTE" + id + "_" + ip, 3600 * 24)) {
            docMapperCust.increaseVoteCount(id);
        } else {
            throw new BusinessException(BusinessExceptionCode.VOTE_REPEAT);
        }
        // websocket推送消息
        Doc docDB = docMapper.selectByPrimaryKey(id);
        String logId = MDC.get("LOG_ID");
        // 异步通知
        // wsService.sendInfo("【" + docDB.getName() + "】被点赞!", logId);
        // MQ通知
        rocketMQTemplate.convertAndSend("VOTE_TOPIC", "【" + docDB.getName() + "】被点赞!");

    }

    public void updateEbookInfo() {
        docMapperCust.updateEbookInfo();
    }

}
