package com.lhx.cephfs.commons.domain.common;

public enum Code {
    OK(0, "OK"),
    UNKNOW_ERROR(1, "服务异常"),
    WRONG_PAGE(10100, "页码不存在"),
    ;

    Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code;
    public String msg;

}
