package com.ovtrip.user.model.mapper;

import com.ovtrip.global.jwt.dto.RefreshTokenDto;
import com.ovtrip.user.model.dto.LoginUserDto;
import com.ovtrip.user.model.dto.SocialLoginUserDto;
import com.ovtrip.user.model.dto.UserDto;
import com.ovtrip.user.model.dto.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Mapper
@Repository
public interface UserMapper {
    // 회원가입시 이메일 중복 체크
    int idCheck(String userEmail) throws SQLException;
    // 회원가입
    Long joinUser(UserDto userDto) throws SQLException;
    // 회원 아이디로 회원 조회
    UserVO getUserById(Long userId) throws SQLException;
    // 회원 이메일로 회원 조회
    UserVO getUserByEmail(String userEmail) throws SQLException;
    // 로그인
    UserVO emailLogin(LoginUserDto loginUserDto) throws SQLException;
    // token set
    void updateRefreshToken(RefreshTokenDto refreshTokenDto) throws SQLException;
    UserVO getUserByRefreshToken(String refreshToken);
    void expireRefreshToken(Long userId);
    UserVO getUserByEmailandSocialType(SocialLoginUserDto socialLoginUserDto);
}
