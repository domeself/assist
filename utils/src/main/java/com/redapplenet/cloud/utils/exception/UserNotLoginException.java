package com.redapplenet.cloud.utils.exception;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/2/27 16:08
 * @Version
 **/
public class UserNotLoginException extends BusinessException {
    public UserNotLoginException(){
        super();
    }
    public UserNotLoginException(String message){
        super(message);
    }
}
