package com.ovtrip.user.model.mapper;

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
    void joinUser(UserDto userDto) throws SQLException;
    // 회원 아이디로 회원 조회
    UserVO getUserById(int userId) throws SQLException;
}
