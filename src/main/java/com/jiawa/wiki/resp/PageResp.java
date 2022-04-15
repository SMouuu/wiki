/*
 * @Author       : SMou
 * @Date         : 2022-04-15 16:07:49
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-15 16:15:53
 * @Description  : 请填写简介
 */
/*
 * @Author       : SMou
 * @Date         : 2022-04-15 15:58:49
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-15 16:01:17
 * @Description  : 请填写简介
 */
package com.jiawa.wiki.resp;

import java.util.List;

public class PageResp<T> {
    private Long total;

    private List<T> list;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageResp [list=" + list + ", total=" + total + "]";
    }

}