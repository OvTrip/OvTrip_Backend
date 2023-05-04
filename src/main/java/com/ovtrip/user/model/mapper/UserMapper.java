package com.ovtrip.user.model.mapper;

import com.ovtrip.user.model.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface UserMapper {
    // 회원가입시 이메일 중복 체크
    int idCheck(String userEmail) throws SQLException;
    // 회원가입
    void joinUser(UserDto userDto) throws SQLException;
    // 회원 아이디로 회원 조회
    UserDto getUserById(int userId) throws SQLException;
}
