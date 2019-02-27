package com.redapplenet.cloud.utils.exception;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/2/27 16:06
 * @Version
 **/
public class RemoteAccessException extends BusinessException {
    public RemoteAccessException(){
        super();
    }
    public RemoteAccessException(String message){
        super(message);
    }
}
