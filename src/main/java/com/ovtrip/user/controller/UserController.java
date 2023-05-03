package com.ovtrip.user.controller;

import com.ovtrip.user.model.UserDto;
import com.ovtrip.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api(tags={"회원관리"})
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "회원가입", notes = "회원 정보를 받아 새로운 회원을 생성합니다.")
    @PostMapping ("/user/auth/signup")
    public CreateUserResponse signup(@RequestBody CreateUserRequest request) throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUserEmail(request.getEmail());
        userDto.setUserNickname(request.getNickname());
        userDto.setUserPassword(request.getPassword());
        userDto.setSocialType("LOCAL");
        userService.joinUser(userDto);
        return new CreateUserResponse(userDto.getUserEmail());
    }

    @ApiOperation(value = "중복 회원 체크", notes = "이미 가입되어 있는 이메일의 경우 1을, 가입되어 있지 않은 이메일의 경우 0을 리턴합니다.")
    @GetMapping("/user/auth/{email}")
    public ResponseEntity<Integer> idCheck(@PathVariable String email) throws Exception {
        int flag = userService.idCheck(email);
        return new ResponseEntity<>(flag, HttpStatus.OK);
    }

    @Data
    static class CreateUserRequest {
        private String email;
        private String nickname;
        private String password;
    }

    @Data
    @AllArgsConstructor
    static class CreateUserResponse {
        private String email;
    }

}
