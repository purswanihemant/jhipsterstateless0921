package com.mycompany.myapp.social.shopify;

import org.apache.commons.lang3.StringUtils;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

import java.util.Map;
import java.util.Optional;

public class ShopifyConnectionFactory extends OAuth2ConnectionFactory<Map<String, Object>> {

    public ShopifyConnectionFactory(String appId, String appSecret, String shopName) {
        super("shopify", new ShopifyServiceProvider(appId, appSecret, shopName), new ShopifyAdapter());
    }

    @Override
    public Connection<Map<String, Object>> createConnection(AccessGrant accessGrant) {
        ShopifyAccessGrant shopifyAccessGrant = (ShopifyAccessGrant) accessGrant;
        String providerUserId = extractProviderUserId(accessGrant);
        ShopifyOAuth2Connection shopifyOAuth2Connection = new ShopifyOAuth2Connection(getProviderId(), Optional.ofNullable(providerUserId).orElse(StringUtils.EMPTY),
            accessGrant.getAccessToken(), accessGrant.getRefreshToken(), accessGrant.getExpireTime(),
            (OAuth2ServiceProvider<Map<String, Object>>) getServiceProvider(), getApiAdapter());
        shopifyOAuth2Connection.setAssociatedUser(shopifyAccessGrant.getAssociatedUser());
        shopifyOAuth2Connection.initKey(getProviderId(), providerUserId);
        return shopifyOAuth2Connection;
    }


}
