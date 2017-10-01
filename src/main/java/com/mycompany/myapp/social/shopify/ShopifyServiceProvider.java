package com.mycompany.myapp.social.shopify;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

import java.util.Map;

public class ShopifyServiceProvider extends AbstractOAuth2ServiceProvider<Map<String, Object>> {

    public ShopifyServiceProvider(String appId, String appSecret, String shopName) {
        super(getOAuth2Template(appId, appSecret, shopName));
    }

    private static OAuth2Template getOAuth2Template(String appId, String appSecret, String shopName) {
        String baseUrl = String.format("https://%s.myshopify.com/admin/oauth/", shopName);

        OAuth2Template oAuth2Template = new ShopifyOAuth2Template(appId, appSecret,
            baseUrl + "authorize",
            baseUrl + "access_token");
        oAuth2Template.setUseParametersForClientAuthentication(true);
        return oAuth2Template;
    }

    public Map<String, Object> getApi(String accessToken) {
        return null;
    }

}
