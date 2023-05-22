package com.ovtrip.user.service;

import com.ovtrip.global.error.ErrorCode;
import com.ovtrip.global.error.exception.BusinessException;
import com.ovtrip.global.jwt.dto.RefreshTokenDto;
import com.ovtrip.user.constant.SocialType;
import com.ovtrip.user.model.dto.LoginUserDto;
import com.ovtrip.user.model.dto.UserDto;
import com.ovtrip.user.model.dto.UserVO;
import com.ovtrip.user.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

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
        userDto.setSocialType(SocialType.EMAIL);
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

    @Override
    public void validateDuplicateUser(UserDto userDto) throws SQLException {
        UserVO userVo = userMapper.getUserByEmail(userDto.getUserEmail());
        if (userVo != null) {
            throw new BusinessException(ErrorCode.ALREADY_REGISTERED_MEMBER);
        }
    }

    @Override
    public int registerUser(UserDto userDto) throws Exception {
        userMapper.joinUser(userDto);
        return userDto.getUserId();
    }

    @Override
    public UserVO getUserByEmail(String userEmail) throws Exception {
        return userMapper.getUserByEmail(userEmail);
    }

    @Override
    public void updateRefreshToken(RefreshTokenDto refreshTokenDto) throws Exception {
        userMapper.updateRefreshToken(refreshTokenDto);
    }
}
