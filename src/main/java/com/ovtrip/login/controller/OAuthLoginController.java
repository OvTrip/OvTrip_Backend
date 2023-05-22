package com.ovtrip.login.controller;

import com.ovtrip.login.dto.OAuthLoginDto;
import com.ovtrip.login.service.OAuthLoginService;
import com.ovtrip.login.validator.OAuthValidator;
import com.ovtrip.user.constant.SocialType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class OAuthLoginController {

    private final OAuthValidator oauthValidator;
    private final OAuthLoginService oauthLoginService;
    @PostMapping("/login")
    public ResponseEntity<OAuthLoginDto.Response> oauthLogin(@RequestBody OAuthLoginDto.Request oauthLoginRequest, HttpServletRequest httpServletRequest) {
        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        oauthValidator.validateAuthorization(authorizationHeader);
        oauthValidator.validateMemberType(oauthLoginRequest.getSocialType());
        String accessToken = authorizationHeader.split(" ")[1];
        OAuthLoginDto.Response jwtTokenResponseDto = oauthLoginService.oauthLogin(accessToken, SocialType.from(oauthLoginRequest.getSocialType()));
        return ResponseEntity.ok(jwtTokenResponseDto);
    }
}
