package com.mycompany.myapp.social.shopify;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;

import java.util.Map;

public class ShopifyOAuth2Template extends OAuth2Template {

    public ShopifyOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
    }

    @Override
    protected AccessGrant createAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn, Map<String, Object> response) {
        return new ShopifyAccessGrant(accessToken, scope, refreshToken, expiresIn, (Map<String, Object>) response.get("associated_user"));
    }
}
