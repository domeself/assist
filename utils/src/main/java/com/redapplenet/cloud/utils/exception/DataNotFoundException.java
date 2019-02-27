package com.redapplenet.cloud.utils.exception;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/2/27 16:08
 * @Version
 **/
public class DataNotFoundException extends  BusinessException {
    public DataNotFoundException(){
        super();
    }
    public DataNotFoundException(String message){
        super(message);
    }
}
