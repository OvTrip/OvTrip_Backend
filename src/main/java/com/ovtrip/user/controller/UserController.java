package com.ovtrip.user.controller;

import com.ovtrip.user.model.UserDto;
import com.ovtrip.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

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
