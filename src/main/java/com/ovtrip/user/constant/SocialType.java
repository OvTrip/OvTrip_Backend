package com.ovtrip.user.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SocialType {
    EMAIL, KAKAO, NAVER;

    public static SocialType from(String type) {
        return SocialType.valueOf(type.toUpperCase());
    }

    public static boolean isSocialType(String type) {
        List<SocialType> socialTypes = Arrays.stream(SocialType.values())
                .filter(socialType -> socialType.name().equals(type))
                .collect(Collectors.toList());
        return socialTypes.size() != 0;
    }
}
