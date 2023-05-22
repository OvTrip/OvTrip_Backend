package com.ovtrip.external.oauth.service;

import com.ovtrip.external.oauth.model.OAuthAttributes;

public interface SocialLoginApiService {
    OAuthAttributes getUserInfo(String accessToken);
}
