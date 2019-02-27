package com.redapplenet.cloud.utils.web.filter;

/**
 * @Description 处理访问记录
 * @Author liuqn
 * @Date 2019/2/27 17:04
 * @Version
 **/
public class TraceUtil {
    private  static ThreadLocal  local = new ThreadLocal();

    public static void saveTraceId(String traceId){

        local.set(traceId);
       /* ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        request.setAttribute("traceId",traceId);*/

    }

    public static String getTraceId(){
       /* ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return (String)request.getAttribute("traceId");*/

        return (String)local.get();
    }
}
