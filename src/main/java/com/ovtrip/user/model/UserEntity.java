package com.ovtrip.user.model;

import lombok.Builder;
import lombok.Data;

@Data
public class UserEntity {
    private int userId;
    private String userEmail;
    private String userPassword;
    private String userNickname;
    private String socialType;

    @Builder
    public UserEntity(int userId, String userEmail, String userPassword, String userNickname, String socialType) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
        this.socialType = socialType;
    }
}