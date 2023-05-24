package com.ovtrip.user.model.dto;

import com.ovtrip.user.constant.Role;
import com.ovtrip.user.constant.SocialType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long userId;
    private String userEmail;
    private String userPassword;
    private String userNickname;
    private SocialType socialType;
    private String profileImg;
    private Role role;
    private String refreshToken;
    private LocalDateTime tokenExpirationTime;

    @Builder
    public UserDto(String userEmail, String userPassword, String userNickname, SocialType socialType, String profileImg, Role role) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
        this.socialType = socialType;
        this.profileImg = profileImg;
        this.role = role;
    }
}
