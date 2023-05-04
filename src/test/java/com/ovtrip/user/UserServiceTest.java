package com.ovtrip.user;

import com.ovtrip.user.model.UserDto;
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
        int USER_ID = 5;
        UserDto userDto = new UserDto();
        userDto.setUserEmail("ustest22@test.com");
        userDto.setUserNickname("testnickname");
        userDto.setUserPassword("1234");
        userDto.setSocialType("LOCAL");
        userService.joinUser(userDto);
        Assertions.assertThat(userService.getUserById(USER_ID).getUserEmail()).isEqualTo(userDto.getUserEmail());
        Assertions.assertThat(userService.getUserById(USER_ID).getUserNickname()).isEqualTo(userDto.getUserNickname());
        Assertions.assertThat(userService.getUserById(USER_ID).getSocialType()).isEqualTo(userDto.getSocialType());
    }
}
