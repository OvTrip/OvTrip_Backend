package com.ovtrip.external.oauth.model;

import com.ovtrip.user.constant.Role;
import com.ovtrip.user.constant.SocialType;
import com.ovtrip.user.model.dto.UserDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OAuthAttributes {

    private String name;
    private String email;
    private String profileImg;
    private SocialType socialType;

    public UserDto toUserDto(SocialType socialType, Role role){
        return UserDto.builder()
                .userNickname(name)
                .userEmail(email)
                .socialType(socialType)
                .profileImg(profileImg)
                .role(role)
                .build();
    }
}