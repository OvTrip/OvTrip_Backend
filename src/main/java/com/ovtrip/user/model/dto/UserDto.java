package com.ovtrip.user.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserDto {
    private String userEmail;
    private String userPassword;
    private String userNickname;
    private String socialType;

    @Builder
    public UserDto(String userEmail, String userPassword, String userNickname, String socialType) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
        this.socialType = socialType;
    }
}
