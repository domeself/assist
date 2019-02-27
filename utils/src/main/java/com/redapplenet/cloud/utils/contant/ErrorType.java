package com.redapplenet.cloud.utils.contant;

import com.redapplenet.cloud.utils.exception.BusinessException;
import com.redapplenet.cloud.utils.exception.ParameterInvalidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/2/27 10:07
 * @Version
 **/
public class ErrorType {
    public static Logger log = LoggerFactory.getLogger(ErrorType.class);
    public static void main(String[] args) throws BusinessException {
        test();
    }

    public static  void test()  {
        try {
            throw new ParameterInvalidException("参数{}无效{}","name","2019");
        } catch (BusinessException e) {
           log.info(e.toString());
        }
    }
}
