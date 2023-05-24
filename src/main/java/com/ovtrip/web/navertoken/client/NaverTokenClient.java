package com.ovtrip.web.navertoken.client;

import com.ovtrip.web.kakaotoken.dto.KakaoTokenDto;
import com.ovtrip.web.navertoken.dto.NaverTokenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "https://nid.naver.com", name = "naverTokenClient")
public interface NaverTokenClient {
    @PostMapping(value = "/oauth2.0/token", consumes = "application/json")
    NaverTokenDto.Response requestNaverToken(@SpringQueryMap NaverTokenDto.Request request);
}
