package com.ovtrip.web.navertoken.dto;

import lombok.*;

public class NaverTokenDto {
    @Builder
    @Getter
    public static class Request {
        private String grant_type;
        private String client_id;
        private String client_secret;
        private String code;
        private String state;
    }

    @Builder
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private String access_token;
        private String refresh_token;
        private String token_type;
        private Integer expires_in;
    }
}
