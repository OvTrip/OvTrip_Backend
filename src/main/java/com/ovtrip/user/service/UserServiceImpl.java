package com.ovtrip.user.service;

import com.ovtrip.user.model.UserDto;
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
        userMapper.joinUser(userDto);
    }


}
