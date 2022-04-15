/*
 * @Author       : SMou
 * @Date         : 2022-04-15 22:15:42
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-15 22:38:53
 * @Description  : 请填写简介
 */
package com.jiawa.wiki.req;

public class UserQueryReq extends PageReq {

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