package com.ovtrip.user.service;

import com.ovtrip.global.error.ErrorCode;
import com.ovtrip.global.error.exception.AuthenticationException;
import com.ovtrip.global.error.exception.BusinessException;
import com.ovtrip.global.error.exception.EntityNotFoundException;
import com.ovtrip.global.jwt.dto.RefreshTokenDto;
import com.ovtrip.user.constant.SocialType;
import com.ovtrip.user.model.dto.*;
import com.ovtrip.user.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

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
    public UserVO getUserById(Long userId) throws Exception {
        UserVO userVO = userMapper.getUserById(userId);
        if (userVO == null){
            throw new EntityNotFoundException(ErrorCode.MEMBER_NOT_EXIST);
        }
        return userVO;
    }

    @Override
    public UserVO emailLogin(LoginUserDto loginUserDto) throws Exception {
        UserVO userVO = userMapper.emailLogin(loginUserDto);
        if (userVO == null){
            throw new EntityNotFoundException(ErrorCode.MEMBER_NOT_EXIST);
        }
        return userVO;
    }

    @Override
    public void validateDuplicateUser(UserDto userDto) throws SQLException {
        UserVO userVo = userMapper.getUserByEmail(userDto.getUserEmail());
        if (userVo != null) {
            throw new BusinessException(ErrorCode.ALREADY_REGISTERED_MEMBER);
        }
    }

    @Override
    public Long registerUser(UserDto userDto) throws Exception {
        userMapper.joinUser(userDto);
        return userDto.getUserId();
    }

    @Override
    public UserVO getUserByEmail(String userEmail) throws Exception {
        UserVO userVO = userMapper.getUserByEmail(userEmail);
        if (userVO == null){
            throw new EntityNotFoundException(ErrorCode.MEMBER_NOT_EXIST);
        }
        return userVO;
    }

    @Override
    public void updateRefreshToken(RefreshTokenDto refreshTokenDto) throws Exception {
        userMapper.updateRefreshToken(refreshTokenDto);
    }

    @Override
    public UserVO getUserByRefreshToken(String refreshToken) {
        UserVO userVO = userMapper.getUserByRefreshToken(refreshToken);
        if (userVO == null) {
            throw new AuthenticationException(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
        }
        LocalDateTime tokenExpirationTime = userVO.getTokenExpirationTime();
        if (tokenExpirationTime.isBefore(LocalDateTime.now())){
            throw new AuthenticationException(ErrorCode.REFRESH_TOKEN_EXPIRED);
        }
        return userVO;
    }

    @Override
    public void expireRefreshToken(Long userId) {
        userMapper.expireRefreshToken(userId);
    }

    @Override
    public UserVO getUserByEmailandSocialType(SocialLoginUserDto socialLoginUserDto) {
        return userMapper.getUserByEmailandSocialType(socialLoginUserDto);
    }

    @Override
    public List<SearchUserDto> searchUserByName(String keyword) {
        return userMapper.searchUserByName(keyword);
    }
}
