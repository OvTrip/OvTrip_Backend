package com.ovtrip.user.model.dto;

import lombok.*;

@Getter
public class UserVO {
    private int userId;
    private String userEmail;
    private String userNickname;
    private String socialType;

    @Builder
    public UserVO(int userId, String userEmail, String userNickname, String socialType) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userNickname = userNickname;
        this.socialType = socialType;
    }
}
