package com.redapplenet.cloud.utils.web.response;

import com.redapplenet.cloud.utils.exception.BusinessException;
import com.redapplenet.cloud.utils.exception.ExceptionInfo;
import com.redapplenet.cloud.utils.web.filter.TraceUtil;

/**
 * @AUTHOR liuqn
 * @DATE 2018/12/4 13:45
 * @VERSION v1.0
 * @DESCRIPTION TODO
 */

public abstract class ResultResponse<T> {
    private String  code ;
    private String message ;
    private String traceId;
    private ExceptionInfo exceptionInfo;

    public ExceptionInfo getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(ExceptionInfo exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

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

    public ResultResponse(){
        this.code = "success";
        this.message = "success";
        this.traceId = TraceUtil.getTraceId();
    }
    public ResultResponse(String code,String message){
        this.code = code;
        this.message = message;
        this.traceId = TraceUtil.getTraceId();
    }

    public ResultResponse(BusinessException exception){
        this.code = exception.getCode();
        this.message = exception.getMessage();
        this.traceId = TraceUtil.getTraceId();
        this.exceptionInfo = exception.getExceptionInfo();
    }
}
