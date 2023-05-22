package com.ovtrip.global.error.exception;

import com.ovtrip.global.error.ErrorCode;

public class AuthenticationException extends BusinessException{
    public AuthenticationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
