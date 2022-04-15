/*
 * @Author       : SMou
 * @Date         : 2022-04-15 22:15:42
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-15 22:22:26
 * @Description  : 请填写简介
 */
package com.jiawa.wiki.req;

public class User1QueryReq extends PageReq {

    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "User1QueryReq [loginName=" + loginName + "]";
    }

}