package com.mycompany.myapp.social.shopify;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;

import java.util.Map;

public class ShopifyAdapter implements ApiAdapter<Map<String, Object>> {

    private Map<String, Object> apiData;

    @Override
    public boolean test(Map<String, Object> api) {
        return true;
    }

    public void setConnectionValues(Map<String, Object> api, ConnectionValues values) {
        this.apiData = api;
        values.setProviderUserId(api.get("id").toString());
        values.setDisplayName(api.get("email").toString());
    }

    @Override
    public UserProfile fetchUserProfile(Map<String, Object> api) {
        return new UserProfileBuilder()
            .setId(apiData.get("id").toString())
            .setUsername(apiData.get("email").toString())
            .setEmail(apiData.get("email").toString())
            .setFirstName(apiData.get("first_name").toString())
            .setLastName(apiData.get("last_name").toString()).build();
    }

    @Override
    public void updateStatus(Map<String, Object> api, String message) {
    }
}
