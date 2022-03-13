package com.shu.ssc.common.result;

public enum ResultCode {
    //    成功状态码
    SUCCESS(1000, "成功"),
    //    参数错误：1001-1999
    PARAM_IS_INVALID(1001, "参数无效"),
    PARAM_ISI_BLANK(1002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(1003, "参数类型错误"),
    PARAM_NOT_COMPLETE(1004, "参数缺失"),
    //    用户错误：2001-2999
    USER_HAS_EXISTED(2001, "用户已存在"),
    USER_NOT_EXIST(2002, "用户不存在"),
    USER_LOGIN_ERROR(2003, "密码错误"),

    //      获取经纬度地址错误: 7001-7999
    FETCH_TRACKS_ERROR(7001, "获取经纬度地址错误"),

    //      未知错误
    UNKNOWN_ERROR(8000, "未知错误");



    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
