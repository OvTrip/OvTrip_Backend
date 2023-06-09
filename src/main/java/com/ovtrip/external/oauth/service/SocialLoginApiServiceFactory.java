package com.ovtrip.external.oauth.service;

import com.ovtrip.user.constant.SocialType;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SocialLoginApiServiceFactory {
    private static Map<String, SocialLoginApiService> socialLoginApiServices;

    public SocialLoginApiServiceFactory(Map<String, SocialLoginApiService> socialLoginApiServices) {
        this.socialLoginApiServices = socialLoginApiServices;
    }

    public static SocialLoginApiService getSocialLoginApiService(SocialType socialType){
        String socialLoginApiServiceBeanName = "";
        if (SocialType.KAKAO.equals(socialType)){
            socialLoginApiServiceBeanName = "kakaoLoginApiServiceImpl";
        } else if (SocialType.NAVER.equals(socialType)) {
            socialLoginApiServiceBeanName = "naverLoginApiServiceImpl";
        }
        return socialLoginApiServices.get(socialLoginApiServiceBeanName);
    }
}
