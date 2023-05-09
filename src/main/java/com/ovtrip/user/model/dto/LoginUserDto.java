package com.ovtrip.user.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class LoginUserDto {
    private String userEmail;
    private String userPassword;
    private String socialType;

    @Builder
    public LoginUserDto(String userEmail, String userPassword, String socialType) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.socialType = socialType;
    }
}
