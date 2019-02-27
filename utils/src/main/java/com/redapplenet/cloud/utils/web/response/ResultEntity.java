package com.redapplenet.cloud.utils.web.response;

import com.redapplenet.cloud.utils.exception.BusinessException;

/**
 * @AUTHOR liuqn
 * @DATE 2018/12/4 15:08
 * @VERSION v1.0
 * @DESCRIPTION TODO
 */

public class ResultEntity<T> extends ResultResponse<T> {
    private T data;

    public ResultEntity() {
       super();
    }
    public ResultEntity(String code,String message){
        super(code,message);
    }
    public ResultEntity(BusinessException exception){
        super(exception);

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
