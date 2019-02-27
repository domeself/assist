package com.redapplenet.cloud.utils.exception;

/**
 * @Description 异常参数
 * @Author liuqn
 * @Date 2019/2/27 14:35
 * @Version 1.0
 **/
public class ExceptionInfo {
    /**
     * 异常ID
     **/
    private String exceptionId;
    /**
     * 异常类型
     **/
    private String exceptionType;
    /**
     * 行号
     **/
    private int lineNumber;
    /**
     * 文件名
     **/
    private String fileName;
    /**
     * 方法名
     **/
    private String methodName;
    /**
     * 类名
     **/
    private String className;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getExceptionId() {
        return exceptionId;
    }

    public void setExceptionId(String exceptionId) {
        this.exceptionId = exceptionId;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "exceptionId="+exceptionId+"\n"
                +"exceptionType="+exceptionType+"\n"
                +"className="+className+"<"+methodName+">("+lineNumber+")";
    }
}
