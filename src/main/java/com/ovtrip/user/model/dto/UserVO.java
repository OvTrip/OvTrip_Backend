package com.ovtrip.user.model.dto;

import com.ovtrip.user.constant.Role;
import com.ovtrip.user.constant.SocialType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
public class UserVO {
    private int userId;
    private String userEmail;
    private String userNickname;
    private SocialType socialType;
    private String profileImg;
    private Role role;
    private String refreshToken;
    private LocalDateTime tokenExpirationTime;
    private LocalDateTime regTime;
    private LocalDateTime modTime;

    @Builder
    public UserVO(int userId, String userEmail, String userNickname, SocialType socialType) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userNickname = userNickname;
        this.socialType = socialType;
    }
}
