package com.ovtrip.global.jwt.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RefreshTokenDto {
    private int userId;
    private String refreshToken;
    private LocalDateTime refreshTokenExpireTime;

    @Builder
    public RefreshTokenDto(int userId, String refreshToken, LocalDateTime refreshTokenExpireTime) {
        this.userId = userId;
        this.refreshToken = refreshToken;
        this.refreshTokenExpireTime = refreshTokenExpireTime;
    }
}
