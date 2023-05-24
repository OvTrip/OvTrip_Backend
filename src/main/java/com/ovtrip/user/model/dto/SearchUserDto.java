package com.ovtrip.user.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SearchUserDto {
    private Long userId;
    private String userEmail;
    private String userNickname;
    private String profileImg;

    @Builder
    public SearchUserDto(Long userId, String userEmail, String userNickname, String profileImg) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userNickname = userNickname;
        this.profileImg = profileImg;
    }
}
