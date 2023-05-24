package com.ovtrip.user.service;

import com.ovtrip.global.jwt.dto.RefreshTokenDto;
import com.ovtrip.user.model.dto.*;

import java.util.List;

public interface UserService {
    int idCheck(String userId) throws Exception;
    void joinUser(UserDto userDto) throws Exception;
    UserVO getUserById(Long userId) throws Exception;
    UserVO emailLogin(LoginUserDto loginUserDto) throws Exception;

    void validateDuplicateUser(UserDto userDto) throws Exception;

    Long registerUser(UserDto userDto) throws Exception;

    UserVO getUserByEmail(String userEmail) throws Exception;

    void updateRefreshToken(RefreshTokenDto refreshTokenDto) throws Exception;

    UserVO getUserByRefreshToken(String refreshToken);

    void expireRefreshToken(Long userId);

    UserVO getUserByEmailandSocialType(SocialLoginUserDto socialLoginUserDto);
    List<SearchUserDto> searchUserByName(String keyword);
}
