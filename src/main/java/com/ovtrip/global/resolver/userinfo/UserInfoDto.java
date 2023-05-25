package com.ovtrip.global.resolver.userinfo;

import com.ovtrip.user.constant.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoDto {

    private Long userId;
    private Role role;
}