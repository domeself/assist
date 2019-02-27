package com.redapplenet.cloud.utils.exception;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/2/27 16:08
 * @Version
 **/
public class DataConflictException extends BusinessException {
    public DataConflictException(){
        super();
    }
    public DataConflictException(String message){
        super(message);
    }
}
