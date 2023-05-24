package com.ovtrip.user.model.dto;

import com.ovtrip.user.constant.SocialType;
import lombok.Builder;
import lombok.Data;

@Data
public class SocialLoginUserDto {
    private String email;
    private SocialType socialType;

    @Builder
    public SocialLoginUserDto(String email, SocialType socialType) {
        this.email = email;
        this.socialType = socialType;
    }
}
