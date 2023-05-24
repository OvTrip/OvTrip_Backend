package com.ovtrip.login.controller;

import com.ovtrip.global.util.AuthorizationHeaderUtils;
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
    @PostMapping("/login/{socialType}")
    public ResponseEntity<OAuthLoginDto.Response> oauthLogin(@PathVariable String socialType, HttpServletRequest httpServletRequest) {
        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        AuthorizationHeaderUtils.validateAuthorization(authorizationHeader);
        oauthValidator.validateSocialType(socialType.toUpperCase());
        String accessToken = authorizationHeader.split(" ")[1];
        OAuthLoginDto.Response jwtTokenResponseDto = oauthLoginService.oauthLogin(accessToken, SocialType.from(socialType));
        return ResponseEntity.ok(jwtTokenResponseDto);
    }
}
