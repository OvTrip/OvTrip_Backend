package com.ovtrip.login.validator;

import com.ovtrip.global.error.ErrorCode;
import com.ovtrip.global.error.exception.BusinessException;
import com.ovtrip.user.constant.SocialType;
import org.springframework.stereotype.Service;

@Service
public class OAuthValidator {

    public void validateSocialType(String socialType) {
        if(!SocialType.isSocialType(socialType)) {
            throw new BusinessException(ErrorCode.INVALID_MEMBER_TYPE);
        }
    }
}
