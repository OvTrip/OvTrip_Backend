package com.ovtrip.user.service;

import com.ovtrip.user.model.dto.LoginUserDto;
import com.ovtrip.user.model.dto.UserDto;
import com.ovtrip.user.model.dto.UserVO;

public interface UserService {
    int idCheck(String userId) throws Exception;
    void joinUser(UserDto userDto) throws Exception;
    UserVO getUserById(int userId) throws Exception;
    UserVO emailLogin(LoginUserDto loginUserDto) throws Exception;
}
