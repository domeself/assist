package com.redapplenet.cloud.utils.exception;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/2/27 16:07
 * @Version
 **/
public class InternalServerException extends BusinessException {
    public InternalServerException(){
        super();
    }
    public InternalServerException(String message){
        super(message);
    }
}
