package com.mycompany.myapp.social.shopify;

import org.springframework.social.oauth2.AccessGrant;

import java.util.Map;

public class ShopifyAccessGrant extends AccessGrant {

    private Map<String, Object> associatedUser;

    public ShopifyAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn, Map<String, Object> associatedUser) {
        super(accessToken, scope, refreshToken, expiresIn);
        this.associatedUser = associatedUser;
    }

    public Map<String, Object> getAssociatedUser() {
        return associatedUser;
    }
}
