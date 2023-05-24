package com.ovtrip.logout.service;

import com.ovtrip.global.error.ErrorCode;
import com.ovtrip.global.error.exception.AuthenticationException;
import com.ovtrip.global.jwt.constant.TokenType;
import com.ovtrip.global.jwt.service.TokenManager;
import com.ovtrip.user.service.UserService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LogoutService {

    private final UserService userService;
    private final TokenManager tokenManager;

    public void logout(String accessToken) throws Exception {
        // 1. 토큰 검증
        tokenManager.validateToken(accessToken);
        // 2. 토큰 타입 검증
        // 토큰 타입이 access token 인지 검증
        Claims tokenClaims = tokenManager.getTokenClaims(accessToken);
        String tokenType = tokenClaims.getSubject();
        if (!TokenType.isAccessToken(tokenType)){
            throw new AuthenticationException(ErrorCode.NOT_ACCESS_TOKEN_TYPE);
        }
        // 3. refresh token 만료 처리
        Long userId = Long.valueOf((Integer) tokenClaims.get("userId"));
        userService.expireRefreshToken(userId);
    }
}
