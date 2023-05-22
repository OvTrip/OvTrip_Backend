package com.ovtrip.external.oauth.kakao.service;

import com.ovtrip.external.oauth.kakao.client.KakaoUserInfoClient;
import com.ovtrip.external.oauth.kakao.dto.KakaoUserInfoResponseDto;
import com.ovtrip.external.oauth.model.OAuthAttributes;
import com.ovtrip.external.oauth.service.SocialLoginApiService;

import com.ovtrip.global.jwt.constant.GrantType;
import com.ovtrip.user.constant.SocialType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class KakaoLoginApiServiceImpl implements SocialLoginApiService {

    private final KakaoUserInfoClient kakaoUserInfoClient;
    private final String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=utf-8";

    @Override
    public OAuthAttributes getUserInfo(String accessToken) {
        // 회원 정보를 가져오는 로직
        KakaoUserInfoResponseDto kakaoUserInfoResponseDto = kakaoUserInfoClient.getKakaoUserInfo(CONTENT_TYPE, GrantType.BEARER.getType() + " " + accessToken);
        KakaoUserInfoResponseDto.KakaoAccount kakaoAccount = kakaoUserInfoResponseDto.getKakaoAccount();
        String email = kakaoAccount.getEmail();
        return OAuthAttributes.builder()
                .email(!StringUtils.hasText(email) ? kakaoUserInfoResponseDto.getId() : email)
                .name(kakaoAccount.getProfile().getNickname())
                .profileImg(kakaoAccount.getProfile().getThumbnailImageUrl())
                .socialType(SocialType.KAKAO)
                .build();
    }
}
