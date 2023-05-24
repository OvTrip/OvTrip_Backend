package com.ovtrip.web.navertoken.controller;

import com.ovtrip.login.dto.OAuthLoginDto;
import com.ovtrip.login.service.OAuthLoginService;
import com.ovtrip.user.constant.SocialType;
import com.ovtrip.web.kakaotoken.client.KakaoTokenClient;
import com.ovtrip.web.kakaotoken.dto.KakaoTokenDto;
import com.ovtrip.web.navertoken.client.NaverTokenClient;
import com.ovtrip.web.navertoken.dto.NaverTokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class NaverTokenController {
    private final NaverTokenClient naverTokenClient;
    private final OAuthLoginService oauthLoginService;

    @Value("${naver.client.id}")
    private String clientId;

    @Value("${naver.client.secret}")
    private String clientSecret;

    @GetMapping("/oauth/naver")
    public @ResponseBody ResponseEntity<OAuthLoginDto.Response> naverLogin(String code, String state) {
        NaverTokenDto.Request naverTokenRequestDto = NaverTokenDto.Request.builder()
                .grant_type("authorization_code")
                .client_id(clientId)
                .client_secret(clientSecret)
                .code(code)
                .state(state)
                .build();
        NaverTokenDto.Response naverToken = naverTokenClient.requestNaverToken(naverTokenRequestDto);
        String accessToken = naverToken.getAccess_token();
        OAuthLoginDto.Response jwtTokenResponseDto = oauthLoginService.oauthLogin(accessToken, SocialType.NAVER);
        return ResponseEntity.ok(jwtTokenResponseDto);
    }
}
