package com.coral.service.auth.enums;

import com.coral.base.common.I18nMessageUtil;
import com.coral.base.common.enums.I18nMessageKey;
import com.coral.base.common.exception.IErrorCodeMessage;

/**
 * auth 错误列表
 * 
 * @author huss
 */

public enum AuthErrorMessageEnum implements IErrorCodeMessage<AuthErrorMessageEnum>, I18nMessageKey {

    /**
     * user not exist
     */
    USER_NOT_EXIST(50001, "user not exist"),

    ;

    private Integer code;
    private String message;

    AuthErrorMessageEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getErrorMsg() {
        return this.message;
    }

    @Override
    public String getMessageKey() {
        return I18nMessageUtil.getMessageKey(this);
    }

    @Override
    public Integer getErrorCode() {
        return this.code;
    }
}