/*
 * @Author       : SMou
 * @Date         : 2022-04-18 16:40:12
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-18 17:00:02
 * @Description  : 请填写简介
 */

package com.jiawa.wiki.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import com.jiawa.wiki.service.DocService;
import com.jiawa.wiki.util.SnowFlake;

@Component
public class DocJob {

    private static final Logger LOG = LoggerFactory.getLogger(DocJob.class);

    @Resource
    private DocService docService;

    @Resource
    private SnowFlake snowFlake;

    /**
     * 每30秒更新电子书信息
     */
    @Scheduled(cron = "1/5 * * * * ?")
    public void cron() {
        // 增加日志流水号
        MDC.put("LOG_ID", String.valueOf(snowFlake.nextId()));
        LOG.info("每隔30秒更新电子书信息");
        long start = System.currentTimeMillis();
        docService.updateEbookInfo();
        LOG.info("每隔30秒更新电子书信息,耗时:{}毫秒", System.currentTimeMillis() - start);
    }

}
