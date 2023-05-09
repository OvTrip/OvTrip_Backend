package com.ovtrip.user.service;

import com.ovtrip.user.model.dto.LoginUserDto;
import com.ovtrip.user.model.dto.UserDto;
import com.ovtrip.user.model.dto.UserVO;
import com.ovtrip.user.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public int idCheck(String userEmail) throws Exception {
        return userMapper.idCheck(userEmail);
    }

    @Override
    public void joinUser(UserDto userDto) throws Exception {
        userDto.setSocialType("LOCAL");
        userMapper.joinUser(userDto);
    }

    @Override
    public UserVO getUserById(int userId) throws Exception {
        return userMapper.getUserById(userId);
    }

    @Override
    public UserVO emailLogin(LoginUserDto loginUserDto) throws Exception {
        return userMapper.emailLogin(loginUserDto);
    }

}
