package com.mycompany.myapp.social.shopify;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2Connection;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

import java.util.Map;

public class ShopifyOAuth2Connection extends OAuth2Connection<Map<String, Object>> {

    private Map<String, Object> associatedUser;

    public ShopifyOAuth2Connection(String providerId, String providerUserId, String accessToken, String refreshToken, Long expireTime,
                                   OAuth2ServiceProvider<Map<String, Object>> serviceProvider, ApiAdapter<Map<String, Object>> apiAdapter) {
        super(providerId, providerUserId, accessToken, refreshToken, expireTime, serviceProvider, apiAdapter);
    }

    public void setAssociatedUser(Map<String, Object> associatedUser) {
        this.associatedUser = associatedUser;
    }

    @Override
    public Map<String, Object> getApi() {
        return associatedUser;
    }

    @Override
    public void initKey(String providerId, String providerUserId) {
        super.initKey(providerId, providerUserId);
    }
}
