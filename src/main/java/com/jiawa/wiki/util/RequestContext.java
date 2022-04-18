/*
 * @Author       : SMou
 * @Date         : 2022-04-18 16:06:51
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-18 16:06:52
 * @Description  : 请填写简介
 */
package com.jiawa.wiki.util;

import java.io.Serializable;

public class RequestContext implements Serializable {

    private static ThreadLocal<String> remoteAddr = new ThreadLocal<>();

    public static String getRemoteAddr() {
        return remoteAddr.get();
    }

    public static void setRemoteAddr(String remoteAddr) {
        RequestContext.remoteAddr.set(remoteAddr);
    }

}
