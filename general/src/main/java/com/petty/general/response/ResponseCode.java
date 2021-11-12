package com.petty.general.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS(200, "请求成功"),

    /**
     * 失败
     */
    FAIL(400, "请求失败"),


    /**
     * 查询失败
     */
    QUERYERROR(500, "查询失败")
    ;
    /**
     * code
     */
    final Integer code;

    /**
     * message desc
     */
    final String message;

    int getCode(){
        return code;
    }
    String getMessage(){
        return message;
    }
}
