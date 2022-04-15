/*
 * @Author       : SMou
 * @Date         : 2022-04-15 22:32:50
 * @LastEditors  : SMou
 * @LastEditTime : 2022-04-15 22:32:51
 * @Description  : 请填写简介
 */
package com.jiawa.wiki.exception;

public class BusinessException extends RuntimeException {

    private BusinessExceptionCode code;

    public BusinessException(BusinessExceptionCode code) {
        super(code.getDesc());
        this.code = code;
    }

    public BusinessExceptionCode getCode() {
        return code;
    }

    public void setCode(BusinessExceptionCode code) {
        this.code = code;
    }

    /**
     * 不写入堆栈信息，提高性能
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
