package com.ovtrip.external.oauth.naver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NaverUserInfoResponseDto {
    private String resultcode;
    private String message;

    @JsonProperty("response")
    private Response response;

    @Getter
    @Setter
    public static class Response {
        private String id;
        private String name;
        private String email;
        @JsonProperty("profile_image")
        private String profileImage;
    }
}
