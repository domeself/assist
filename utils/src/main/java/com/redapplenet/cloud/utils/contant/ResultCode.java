package com.redapplenet.cloud.utils.contant;

public enum ResultCode {
    PARAM_IS_INVALID("1001","参数无效"),
    RESULE_DATA_NONE("2001","数据不存在"),
    DATA_ALREADY_EXISTED("3001","数据已经存在"),
    USER_NOT_LOGGED_IN("4001","会员未登录"),
    PERMISSION_NO_ACCESS("5001","会员未授权"),
    INTERFACE_OUTTER_INVOKE_ERROR("6001","远程调用错误"),
    SYSTEM_INNER_ERROR("7001","系统内部错误");
    private String resultCode;
    private String message;
    private ResultCode(String resultCode,String message){
        this.message=message;
        this.resultCode=resultCode;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
