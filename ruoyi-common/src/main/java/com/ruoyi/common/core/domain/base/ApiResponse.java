package com.ruoyi.common.core.domain.base;


import lombok.Data;

import java.io.Serializable;


@Data
public class ApiResponse<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    private ApiResponse() {

    }

    private ApiResponse(T data) {
        this.data = data;
    }

    private ApiResponse(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    private ApiResponse(int code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> of(int code, String message) {
        return new ApiResponse<T>(code, message, null);
    }

    public static <T> ApiResponse<T> of(int code, T data) {
        return new ApiResponse<T>(code, "", data);
    }

    public static <T> ApiResponse<T> of(int code, String message, T data) {
        return new ApiResponse<T>(code, message, data);
    }

    public static <T> ApiResponse<T> of(ApiResultCode resultCode, String message, T data) {
        return new ApiResponse<T>(resultCode.code, message, data);
    }


    public static <T> ApiResponse<T> ok() {
        return new ApiResponse<T>(ApiResultCode.SUCCESS.code, ApiResultCode.SUCCESS.message, null);
    }


    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<T>(ApiResultCode.SUCCESS.code, ApiResultCode.SUCCESS.message, data);
    }


    public static <T> ApiResponse<T> ok(String message) {
        return new ApiResponse<T>(ApiResultCode.SUCCESS.code, message, null);
    }


    public static <T> ApiResponse<T> ok(String message, T data) {
        return new ApiResponse<T>(ApiResultCode.SUCCESS.code, message, data);
    }

    public static <T> ApiResponse<T> fail() {
        return new ApiResponse<T>(ApiResultCode.INTERNAL_SERVER_ERROR.code, ApiResultCode.SUCCESS.message, null);
    }


    public static <T> ApiResponse<T> fail(String message) {
        return new ApiResponse<T>(ApiResultCode.INTERNAL_SERVER_ERROR.code, message, null);
    }


    public static <T> ApiResponse<T> fail(T data) {
        return new ApiResponse<T>(ApiResultCode.INTERNAL_SERVER_ERROR.code, ApiResultCode.INTERNAL_SERVER_ERROR.message, data);
    }


    public static <T> ApiResponse<T> fail(String message, T data) {
        return new ApiResponse<T>(ApiResultCode.INTERNAL_SERVER_ERROR.code, message, data);
    }

    public boolean hasOk() {
        return ApiResultCode.SUCCESS.code == this.code;
    }


}
