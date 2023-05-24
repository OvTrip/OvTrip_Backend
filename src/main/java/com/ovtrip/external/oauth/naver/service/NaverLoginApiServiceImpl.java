package com.ovtrip.external.oauth.naver.service;

import com.ovtrip.external.oauth.model.OAuthAttributes;
import com.ovtrip.external.oauth.naver.client.NaverUserInfoClient;
import com.ovtrip.external.oauth.naver.dto.NaverUserInfoResponseDto;
import com.ovtrip.external.oauth.service.SocialLoginApiService;
import com.ovtrip.global.jwt.constant.GrantType;
import com.ovtrip.user.constant.SocialType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class NaverLoginApiServiceImpl implements SocialLoginApiService {

    private final NaverUserInfoClient naverUserInfoClient;
    @Override
    public OAuthAttributes getUserInfo(String accessToken) {
        NaverUserInfoResponseDto naverUserInfoResponseDto = naverUserInfoClient.getNaverUserInfo(GrantType.BEARER.getType() + " " + accessToken);
        NaverUserInfoResponseDto.Response response = naverUserInfoResponseDto.getResponse();
        return OAuthAttributes.builder()
                .email(response.getEmail())
                .name(response.getName())
                .profileImg(response.getProfileImage())
                .socialType(SocialType.NAVER)
                .build();
    }
}
