package com.ovtrip.user;

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
}
