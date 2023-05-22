package com.ovtrip.web.kakaotoken.controller;

import com.ovtrip.login.dto.OAuthLoginDto;
import com.ovtrip.login.service.OAuthLoginService;
import com.ovtrip.user.constant.SocialType;
import com.ovtrip.web.kakaotoken.client.KakaoTokenClient;
import com.ovtrip.web.kakaotoken.dto.KakaoTokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class KakaoTokenController {
    private final KakaoTokenClient kakaoTokenClient;
    private final OAuthLoginService oauthLoginService;

    @Value("${kakao.client.id}")
    private String clientId;

    @Value("${kakao.client.secret}")
    private String clientSecret;

    @GetMapping("/oauth/kakao")
    public @ResponseBody ResponseEntity<OAuthLoginDto.Response> kakaoLogin(String code) {
        String contentType = "application/x-www-form-urlencoded;charset=utf-8";
        KakaoTokenDto.Request kakaoTokenRequestDto = KakaoTokenDto.Request.builder()
                .client_id(clientId)
                .client_secret(clientSecret)
                .grant_type("authorization_code")
                .code(code)
                .redirect_uri("http://localhost:8081/oauth/kakao/callback")
                .build();
        KakaoTokenDto.Response kakaoToken = kakaoTokenClient.requestKakaoToken(contentType, kakaoTokenRequestDto);
        String accessToken = kakaoToken.getAccess_token();
        OAuthLoginDto.Response jwtTokenResponseDto = oauthLoginService.oauthLogin(accessToken, SocialType.KAKAO);
        return ResponseEntity.ok(jwtTokenResponseDto);
    }
}