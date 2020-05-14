package com.lustre.mall.core.dto;

import lombok.Data;

@Data
public class ResponseResult<T> {

    private int code;

    private String msg;

    private T data;

    public ResponseResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult() {

    }
}
