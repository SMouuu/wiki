/*
 * @Author       : SMou
 * @Date         : 2022-04-16 17:16:46
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-16 17:17:00
 * @Description  : 请填写简介
 */
/*
 * @Author       : SMou
 * @Date         : 2022-04-15 22:18:00
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-15 22:19:21
 * @Description  : 请填写简介
 */
package com.jiawa.wiki.resp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserLoginResp {
    private Long id;

    private String loginName;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginName=").append(loginName);
        sb.append(", name=").append(name);
        sb.append("]");
        return sb.toString();
    }
}