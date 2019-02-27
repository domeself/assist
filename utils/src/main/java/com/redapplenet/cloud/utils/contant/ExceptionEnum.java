package com.redapplenet.cloud.utils.contant;

import com.redapplenet.cloud.utils.exception.*;


public enum ExceptionEnum {

    /**
     * 无效参数
     */
    PARAMETER_INVALID(ParameterInvalidException.class, ResultCode.PARAM_IS_INVALID),

    /**
     * 数据未找到
     */
    NOT_FOUND(DataNotFoundException.class, ResultCode.RESULE_DATA_NONE),

    /**
     * 数据已存在
     */
    CONFLICT(DataConflictException.class, ResultCode.DATA_ALREADY_EXISTED),

    /**
     * 用户未登录
     */
    UNAUTHORIZED(UserNotLoginException.class, ResultCode.USER_NOT_LOGGED_IN),

    /**
     * 无访问权限
     */
    FORBIDDEN(PermissionForbiddenException.class, ResultCode.PERMISSION_NO_ACCESS),

    /**
     * 远程访问时错误
     */
    REMOTE_ACCESS_ERROR(RemoteAccessException.class, ResultCode.INTERFACE_OUTTER_INVOKE_ERROR),

    /**
     * 系统内部错误
     */
    INTERNAL_SERVER_ERROR(InternalServerException.class, ResultCode.SYSTEM_INNER_ERROR);

    private ResultCode resultCode;
    private Class aClass;

    private ExceptionEnum(Class aClass, ResultCode resultCode){
        this.aClass = aClass;
        this.resultCode = resultCode;
    }

    public static ResultCode getRusultCodeByClassType(Class aClass){
        if(aClass==null){
            return null;
        }
        for (ExceptionEnum filedErrorType:ExceptionEnum.values()) {
            if(filedErrorType.aClass.equals(aClass)){
                return  filedErrorType.resultCode;
            }
        }
        return null;
    }
}
