package com.ovtrip.user.service;

import com.ovtrip.user.model.UserDto;

public interface UserService {
    int idCheck(String userId) throws Exception;
    void joinUser(UserDto userDto) throws Exception;
}
