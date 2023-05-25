package com.ovtrip.global.resolver.userinfo;

import com.ovtrip.global.jwt.service.TokenManager;
import com.ovtrip.user.constant.Role;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

@Component
@RequiredArgsConstructor
public class UserInfoArgumentResolver implements HandlerMethodArgumentResolver {

    private final TokenManager tokenManager;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean hasUserInfoAnnotation = parameter.hasParameterAnnotation(UserInfo.class);
        boolean hasUserInfoDto = UserInfoDto.class.isAssignableFrom(parameter.getParameterType());
        return hasUserInfoAnnotation && hasUserInfoDto;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // 토큰에 있던 정보를 UserInfoDto로 만들어 반환
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String authorizationHeader = request.getHeader("Authorization");
        String token = authorizationHeader.split(" ")[1];
        Claims tokenClaims = tokenManager.getTokenClaims(token);
        Long userrId = Long.valueOf((Integer) tokenClaims.get("userId"));
        String role = (String) tokenClaims.get("role");
        // Role 타입을 넘겨야하는데 String이다.
        return UserInfoDto.builder()
                .userId(userrId)
                .role(Role.from(role))
                .build();
    }
}