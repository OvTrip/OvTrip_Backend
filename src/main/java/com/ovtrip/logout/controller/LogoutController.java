package com.ovtrip.logout.controller;

import com.ovtrip.global.util.AuthorizationHeaderUtils;
import com.ovtrip.logout.service.LogoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class LogoutController {
    private final LogoutService logoutService;
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest httpServletRequest) throws Exception {
        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        AuthorizationHeaderUtils.validateAuthorization(authorizationHeader);
        String accessToken = authorizationHeader.split(" ")[1];
        logoutService.logout(accessToken);
        return ResponseEntity.ok("logout success");
    }
}
