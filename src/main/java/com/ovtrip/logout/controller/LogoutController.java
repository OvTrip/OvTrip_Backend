package com.ovtrip.logout.controller;

import com.ovtrip.logout.service.LogoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LogoutController {
    private final LogoutService logoutService;
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String authorizationHeader) throws Exception {
        String accessToken = authorizationHeader.split(" ")[1];
        logoutService.logout(accessToken);
        return ResponseEntity.ok("logout success");
    }
}
