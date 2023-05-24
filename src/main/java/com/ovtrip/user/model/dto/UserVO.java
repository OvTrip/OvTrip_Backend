package com.ovtrip.user.model.dto;

import com.ovtrip.user.constant.Role;
import com.ovtrip.user.constant.SocialType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
public class UserVO {
    private Long userId;
    private String userEmail;
    private String userNickname;
    private SocialType socialType;
    private Role role;
    private String profileImg;
    private LocalDateTime regTime;
    private LocalDateTime modTime;
    private String refreshToken;
    private LocalDateTime tokenExpirationTime;

    @Builder
    public UserVO(Long userId, String userEmail, String userNickname, SocialType socialType, Role role, String profileImg, LocalDateTime regTime, LocalDateTime modTime, String refreshToken, LocalDateTime tokenExpirationTime) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userNickname = userNickname;
        this.socialType = socialType;
        this.role = role;
        this.profileImg = profileImg;
        this.regTime = regTime;
        this.modTime = modTime;
        this.refreshToken = refreshToken;
        this.tokenExpirationTime = tokenExpirationTime;
    }
}
