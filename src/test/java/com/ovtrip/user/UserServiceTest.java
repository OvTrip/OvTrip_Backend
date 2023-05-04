package com.ovtrip.user;

import com.ovtrip.user.model.dto.UserDto;
import com.ovtrip.user.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    void 중복회원테스트() throws Exception {
        Assertions.assertThat(userService.idCheck("test@test.com")).isEqualTo(1);
        Assertions.assertThat(userService.idCheck("tdsfdsdf@test.com")).isEqualTo(0);
    }

    @Test
    void 회원가입테스트() throws Exception {
        int USER_ID = 8;
        UserDto userDto = UserDto.builder()
                .userEmail("ustest88@test.com")
                .userNickname("테스트8")
                .userPassword("1234")
                .build();
        userService.joinUser(userDto);
        Assertions.assertThat(userService.getUserById(USER_ID).getUserEmail()).isEqualTo(userDto.getUserEmail());
        Assertions.assertThat(userService.getUserById(USER_ID).getUserNickname()).isEqualTo(userDto.getUserNickname());
        Assertions.assertThat(userService.getUserById(USER_ID).getSocialType()).isEqualTo("LOCAL");
    }

    @Test
    void ID로_회원조회_테스트() throws Exception {
        int USER_ID = 7;
        Assertions.assertThat(userService.getUserById(USER_ID).getUserEmail()).isEqualTo("ustest77@test.com");
        Assertions.assertThat(userService.getUserById(USER_ID).getUserNickname()).isEqualTo("테스트7");
        Assertions.assertThat(userService.getUserById(USER_ID).getSocialType()).isEqualTo("LOCAL");
    }
}
