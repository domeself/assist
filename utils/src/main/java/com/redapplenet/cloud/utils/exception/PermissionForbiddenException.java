package com.redapplenet.cloud.utils.exception;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/2/27 16:07
 * @Version
 **/
public class PermissionForbiddenException extends BusinessException {
    public PermissionForbiddenException(){
        super();
    }
    public PermissionForbiddenException(String message){
        super(message);
    }
}
