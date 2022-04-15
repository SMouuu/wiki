/*
 * @Author       : SMou
 * @Date         : 2022-04-15 15:58:49
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-15 16:01:17
 * @Description  : 请填写简介
 */
package com.jiawa.wiki.req;

public class PageReq {
    private int page;

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