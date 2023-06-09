package com.ovtrip.login.service;

import com.ovtrip.external.oauth.model.OAuthAttributes;
import com.ovtrip.external.oauth.service.SocialLoginApiService;
import com.ovtrip.external.oauth.service.SocialLoginApiServiceFactory;
import com.ovtrip.global.jwt.dto.JwtTokenDto;
import com.ovtrip.global.jwt.dto.RefreshTokenDto;
import com.ovtrip.global.jwt.service.TokenManager;
import com.ovtrip.global.util.DateTimeUtils;
import com.ovtrip.login.dto.OAuthLoginDto;
import com.ovtrip.user.constant.Role;
import com.ovtrip.user.constant.SocialType;
import com.ovtrip.user.model.dto.SocialLoginUserDto;
import com.ovtrip.user.model.dto.UserDto;
import com.ovtrip.user.model.dto.UserVO;
import com.ovtrip.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class OAuthLoginService {

    private final UserService userService;
    private final TokenManager tokenManager;

    public OAuthLoginDto.Response oauthLogin(String accessToken, SocialType socialType) {
        SocialLoginApiService socialLoginApiService = SocialLoginApiServiceFactory.getSocialLoginApiService(socialType);
        OAuthAttributes userInfo = socialLoginApiService.getUserInfo(accessToken);
        log.info("userinfo : {}", userInfo);
        JwtTokenDto jwtTokenDto;
        SocialLoginUserDto socialLoginUserDto = SocialLoginUserDto.builder()
                .email(userInfo.getEmail())
                .socialType(socialType)
                .build();
        try {
            UserVO userVO = userService.getUserByEmailandSocialType(socialLoginUserDto);
            if (userVO == null){
                // 신규 회원인 경우
                UserDto oauthUser = userInfo.toUserDto(socialType, Role.USER);
                Long userId = userService.registerUser(oauthUser);
                jwtTokenDto = tokenManager.createJwtTokenDto(userId, oauthUser.getRole());
                RefreshTokenDto refreshTokenDto = RefreshTokenDto.builder()
                        .userId(userId)
                        .refreshToken(jwtTokenDto.getRefreshToken())
                        .refreshTokenExpireTime(DateTimeUtils.convertToLocalDateTime(jwtTokenDto.getRefreshTokenExpireTime()))
                        .build();
                userService.updateRefreshToken(refreshTokenDto);
            } else {
                // 가입된 회원의 경우
                jwtTokenDto = tokenManager.createJwtTokenDto(userVO.getUserId(), userVO.getRole());
                RefreshTokenDto refreshTokenDto = RefreshTokenDto.builder()
                        .userId(userVO.getUserId())
                        .refreshToken(jwtTokenDto.getRefreshToken())
                        .refreshTokenExpireTime(DateTimeUtils.convertToLocalDateTime(jwtTokenDto.getRefreshTokenExpireTime()))
                        .build();
                userService.updateRefreshToken(refreshTokenDto);
            }
            return OAuthLoginDto.Response.of(jwtTokenDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
