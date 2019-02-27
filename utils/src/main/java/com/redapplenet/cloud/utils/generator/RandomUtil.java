package com.redapplenet.cloud.utils.generator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * @Author liuqn
 * @Description 指定范围生成随机结果
 * @Date 18:10 2019/2/26
 * @Param
 * @return
 **/
public class RandomUtil {
    public static String base = "abcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * @Author liuqn
     * @Description min-max中的随机数
     * @Date 18:11 2019/2/26
     * @Param [min, max]
     * @return int
     **/
    public static  int randomInt(int min,int max){
        return min+(int)(Math.random()*(max-min+1));
    }

    /**
     * @Author liuqn
     * @Description min-max中的随机数
     * @Date 18:11 2019/2/26
     * @Param [min, max]
     * @return long
     **/
    public static  long randomLong(long min,long max){
        return   min + (long)(new Random().nextDouble() * (max - min+1));
    }

    /**
     * @Author liuqn
     * @Description 指定年份区间随机日期
     * @Date 18:13 2019/2/26
     * @Param [fromDate, toDate]
     * @return java.lang.String
     **/
    public static  String randomDate(int fromDate,int toDate){
        int month = randomInt(1, 12);
        int maxDay = 31;
        if (month==2){
            maxDay=28;
        }
        if(month==4||month==6||month==9|month==11){
            maxDay=30;
        }
        int day = randomInt(1, 30);
        return randomInt(fromDate,toDate)+"-"+(month<10?"0"+month:month)+"-"+(day<10?"0"+day:day);

    }

    /**
     * @Author liuqn
     * @Description 随机时间
     * @Date 18:13 2019/2/26
     * @Param []
     * @return java.lang.String
     **/
    public static String randomTime(){
        int i = randomInt(0, 23);
        return (i<10?"0"+i:i)+":"+randomInt(0,6)+"0";
    }

    /**
     * @Author liuqn
     * @Description 指定年份范围随机日期 时间  yyyy-MM-dd hh:mm
     * @Date 18:14 2019/2/26
     * @Param [fromDate, toDate]
     * @return java.lang.String
     **/
    public static String randomDateTime(int fromDate,int toDate){
        return randomDate(fromDate,toDate)+" "+randomTime();
    }

    /**
     * @Author liuqn
     * @Description 指定年份范围随机日期 时间  yyyyMMdd hh:mm
     * @Date 18:15 2019/2/26
     * @Param [fromDate, toDate]
     * @return java.lang.String
     **/
    public static  String randomDate8(int fromDate,int toDate){
        return randomDate(fromDate,toDate).replace("-","").replace(" ","");
    }

    /**
     * @Author liuqn
     * @Description 随机字符串
     * @Date 18:16 2019/2/26
     * @Param [num]
     * @return java.lang.String
     **/
    public static String randomStr(int num){
        StringBuffer sb = new StringBuffer(num);
        while(num>0){
            sb.append(base.charAt(randomInt(0,base.length()-1)));
            num--;
        }
        return sb.toString();
    }

    /**
     * @Author liuqn
     * @Description 随机日期
     * @Date 18:17 2019/2/26
     * @Param [begin, end]
     * @return java.lang.String
     **/
    public static String randomDateStr(String begin,String end) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(begin);
        System.out.println("-----------------------------");
        long beginLong = sdf.parse(begin).getTime();

        long endLong = sdf.parse(end).getTime();
        System.out.println(end);
        System.out.println("-----------------------------");

        long randomLong = RandomUtil.randomLong(beginLong, endLong);
        return sdf.format(new Date(randomLong));

    }
}