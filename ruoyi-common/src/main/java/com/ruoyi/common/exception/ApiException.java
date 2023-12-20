package com.ruoyi.common.exception;


import com.ruoyi.common.core.domain.base.ApiResultCode;

/**
 * @author ashui
 * @desc api异常类
 * @date 2018/7/3
 */
public class ApiException extends RuntimeException {

    private final static String DEF_MSG = "非法请求";

    private final ApiResultCode code;
    private Object object;
    private boolean isLog = false;

    public boolean isLog() {
        return isLog;
    }

    public ApiResultCode getCode() {
        return code;
    }

    public Object getObject() {
        return object;
    }

    public ApiException(ApiResultCode code) {
        super(code.message);
        this.code = code;
    }

    public ApiException(ApiResultCode code, String message) {
        super(message);
        this.code = code;
    }

    public ApiException(ApiResultCode code, String message, Object object) {
        super(message);
        this.code = code;
        this.object = object;
    }

    public ApiException(ApiResultCode code, String message, Object object, boolean isLog) {
        super(message);
        this.code = code;
        this.object = object;
        this.isLog = isLog;
    }


    /**
     * @desc 异常并且打印错误
     * @author ashui
     * @date 2018/10/23
     */
    public static void throwExceptionAndLog(String msg) throws ApiException {
        throw new ApiException(ApiResultCode.INTERNAL_SERVER_ERROR, msg, null, true);
    }



    /**
     * 自定义错误信息
     *
     * @param msg
     * @throws ApiException
     * @author ashui
     */
    public static void throwException(String msg) throws ApiException {
        throw new ApiException(ApiResultCode.INTERNAL_SERVER_ERROR, msg);
    }

    /**
     * 自定义错误信息
     *
     * @param msg
     * @throws ApiException
     * @author ashui
     */
    public static void throwException(String msg, Object o) throws ApiException {
        throw new ApiException(ApiResultCode.INTERNAL_SERVER_ERROR, msg, o);
    }



    /**
     * 自定义错误信息
     *
     * @param msg
     * @throws ApiException
     * @author ashui
     */
    public static void throwException(ApiResultCode resultCode,String msg) throws ApiException {
        throw new ApiException(resultCode, msg, null);
    }




    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
