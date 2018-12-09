package com.redapplenet.cloud.utils.web.response;

/**
 * @AUTHOR liuqn
 * @DATE 2018/12/4 13:45
 * @VERSION v1.0
 * @DESCRIPTION TODO
 */

public abstract class ResultResponse<T> {
    private String  code ;
    private String message ;



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void  copyResultEntity(ResultResponse resultResponseEntity){
        this.code= resultResponseEntity.getCode();
        this.message= resultResponseEntity.getMessage();
    }
}
