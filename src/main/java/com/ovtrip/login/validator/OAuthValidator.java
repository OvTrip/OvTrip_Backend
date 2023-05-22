package com.ovtrip.login.validator;

import com.ovtrip.global.error.ErrorCode;
import com.ovtrip.global.error.exception.AuthenticationException;
import com.ovtrip.global.error.exception.BusinessException;
import com.ovtrip.global.jwt.constant.GrantType;
import com.ovtrip.user.constant.SocialType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class OAuthValidator {
    public void validateAuthorization(String authorizationHeader){
        // 1. authorizationHeader 필수 체크
        if (!StringUtils.hasText(authorizationHeader)){
            throw new AuthenticationException(ErrorCode.NOT_EXIST_AUTHORIZATION);
        }
        // 2. authorizationHeader Bearer 체크
        String[] authorizations = authorizationHeader.split(" ");
        if (authorizations.length < 2 || (!GrantType.BEARER.getType().equals(authorizations[0]))){
            throw new AuthenticationException(ErrorCode.NOT_VALID_BEARER_GRANT_TYPE);
        }
    }

    public void validateMemberType(String socialType) {
        if(!SocialType.isSocialType(socialType)) {
            throw new BusinessException(ErrorCode.INVALID_MEMBER_TYPE);
        }
    }
}
