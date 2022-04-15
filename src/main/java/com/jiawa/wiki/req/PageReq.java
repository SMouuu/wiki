/*
 * @Author       : SMou
 * @Date         : 2022-04-15 15:58:49
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-15 17:28:22
 * @Description  : 请填写简介
 */
package com.jiawa.wiki.req;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class PageReq {
    @NotNull(message = "【页码】不能为空")
    private int page;

    @NotNull(message = "【每页条数】不能为空")
    @Max(value = 1000, message = "【每页条数】不能超过1000")
    private int size;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PageReq [page=" + page + ", size=" + size + "]";
    }

}