package com.redapplenet.cloud.utils;

/**
 * @AUTHOR liuqn
 * @DATE 2018/12/4 15:08
 * @VERSION v1.0
 * @DESCRIPTION TODO
 */

public class ResultEntity<T> extends ResultResponse<T> {
    private T data;

    public ResultEntity() {
        this("0", "success");
    }
    public ResultEntity(String code,String message) {
        setCode(code);
        setMessage(message);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
