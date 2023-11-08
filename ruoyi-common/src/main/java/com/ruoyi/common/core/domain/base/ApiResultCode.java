package com.ruoyi.common.core.domain.base;

public enum ApiResultCode {

    // 成功
    SUCCESS(200, "Succ"),

    // 接口不存在
    NOT_FOUND(404, "Not Found"),

    // 提示用户报错
    INTERNAL_SERVER_ERROR(500, "Error"),
    ;

    public final int code;
    public final String message;

    ApiResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
