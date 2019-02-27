package com.redapplenet.cloud.utils.exception;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/2/27 15:32
 * @Version
 **/
public class ParameterInvalidException extends BusinessException {
    public ParameterInvalidException(){
        super();
    }
    public ParameterInvalidException(String message){
        super(message);
    }
    public ParameterInvalidException(String message,Object... args){
        super(message,args);
    }
}
