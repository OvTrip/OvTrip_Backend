package com.ovtrip.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private int userId;
    private String userEmail;
    private String userPassword;
    private String userNickname;
    private String socialType;
}