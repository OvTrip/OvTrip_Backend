package com.ovtrip.user.controller;

import com.ovtrip.global.jwt.service.TokenManager;
import com.ovtrip.user.model.dto.LoginUserDto;
import com.ovtrip.user.model.dto.UserDto;
import com.ovtrip.user.model.dto.UserVO;
import com.ovtrip.user.service.UserService;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api(tags={"회원관리"})
public class UserController {
    private final UserService userService;
    private final TokenManager tokenManager;

    @ApiOperation(value = "회원가입", notes = "회원 정보를 받아 새로운 회원을 생성합니다.")
    @PostMapping ("/auth/user/signup")
    public ResponseEntity<?> signup(@RequestBody UserDto userDto) throws Exception {
        userService.joinUser(userDto);
        return new ResponseEntity<>(userDto.getUserEmail(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "중복 회원 체크", notes = "이미 가입되어 있는 이메일의 경우 1을, 가입되어 있지 않은 이메일의 경우 0을 리턴합니다.")
    @GetMapping("/auth/user/{email}")
    public ResponseEntity<?> idCheck(@PathVariable String email) throws Exception {
        int flag = userService.idCheck(email);
        return new ResponseEntity<>(flag, HttpStatus.OK);
    }

    @ApiOperation(value = "로그인", notes = "아이디, 비밀번호를 입력해 로그인을 진행합니다.")
    @PostMapping ("/auth/user/login")
    public ResponseEntity<?> emailLogin(@RequestBody LoginUserDto loginUserDto) throws Exception {
        UserVO userVO = userService.emailLogin(loginUserDto);
        if (userVO == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(userVO, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserInfo(@RequestHeader("Authorization") String authorizationHeader) throws Exception {
        String accessToken = authorizationHeader.split(" ")[1];
        Claims tokenClaims = tokenManager.getTokenClaims(accessToken);
        Long userId = Long.valueOf((Integer) tokenClaims.get("userId"));
        UserVO userVo = userService.getUserById(userId);
        return ResponseEntity.ok(userVo);
    }
}
