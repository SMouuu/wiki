/*
 * @Author       : SMou
 * @Date         : 2022-04-18 15:47:23
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-18 16:42:49
 * @Description  : 请填写简介
 */

package com.jiawa.wiki.mapper;

import org.apache.ibatis.annotations.Param;

public interface DocMapperCust {
    public void increaseViewCount(@Param("id") Long id);

    public void increaseVoteCount(@Param("id") Long id);

    public void updateEbookInfo();
}
