package com.redapplenet.cloud.utils.generator;

import java.util.Random;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/2/26 21:09
 * @Version
 **/
public class VerificationCodeGenerator {
    /**
     * @Author liuqn
     * @Description 生成验证码
     * @Date 15:38 2019/2/26
     * @Param []
     * @return java.lang.String
     **/
    public static String generate(){
        int max=1000000;
        int min=100000;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return String.valueOf(s);
    }
}
