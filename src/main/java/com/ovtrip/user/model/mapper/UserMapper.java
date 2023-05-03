package com.ovtrip.user.model.mapper;

import com.ovtrip.user.model.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    // 회원가입시 이메일 중복 체크
    int idCheck(String userId) throws SQLException;
    // 회원가입
    void joinUser(UserDto userDto) throws SQLException;
    // 로그인
    UserDto loginUser(Map<String, String> map) throws SQLException;
    // 전체 회원 조회
    List<UserDto> listUsers(Map<String, Object> map) throws SQLException;
    // 회원 아이디로 회원 조회
    UserDto getUserById(String userId) throws SQLException;
    // 회원 검색으로 회원 조회
    UserDto getUserBySearch(String keyword) throws SQLException;
    // 회원 정보 수정
    void updateUser(UserDto userDto) throws SQLException;
    // 회원 삭제
    void deleteUser(String userId) throws SQLException;
}
