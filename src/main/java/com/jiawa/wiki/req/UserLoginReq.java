/*
 * @Author       : SMou
 * @Date         : 2022-04-16 17:14:56
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-16 18:00:25
 * @Description  : 请填写简介
 */
/*
 * @Author       : SMou
 * @Date         : 2022-04-15 22:18:00
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-15 22:19:21
 * @Description  : 请填写简介
 */
package com.jiawa.wiki.req;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserLoginReq {

    @NotEmpty(message = "【用户名】不能为空")
    private String loginName;

    @NotEmpty(message = "【密码】不能为空")
    // @Length(min = 6, max = 20, message = "【密码】6~20位")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,32}$", message = "【密码】规则不准确")
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", loginName=").append(loginName);
        sb.append(", password=").append(password);
        sb.append("]");
        return sb.toString();
    }
}