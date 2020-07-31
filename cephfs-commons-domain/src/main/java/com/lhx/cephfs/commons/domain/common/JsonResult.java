package com.lhx.cephfs.commons.domain.common;

import lombok.Data;

@Data
public class JsonResult<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> JsonResult<T> success() {
        return new JsonResult<>();
    }

    public static <T> JsonResult<T> success(T data) {
        JsonResult JsonResult = new JsonResult();
        JsonResult.setData(data);
        return JsonResult;
    }

    public static <T> JsonResult<T> error(Code restCode) {
        JsonResult<T> JsonResult = new JsonResult<>(restCode.code, restCode.msg);
        return JsonResult;
    }

    public JsonResult() {
        //默认会调用有参的构造函数,默认是成功的
        this(Code.OK.code, Code.OK.msg);
    }

    public JsonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(T data) {
        this.data = data;
    }
}
