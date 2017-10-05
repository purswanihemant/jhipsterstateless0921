package com.mycompany.myapp.social.shopify;

import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class ShopifyServiceProvider implements OAuth2ServiceProvider<Map<String, Object>> {

    private static final String SHOP_NAME_SESS_ATTR = "shopName";
    private String appId;
    private String appSecret;

    public ShopifyServiceProvider(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

    @Override
    public OAuth2Operations getOAuthOperations() {
        String shopName = getShopName();
        String baseUrl = String.format("https://%s.myshopify.com/admin/oauth/", shopName);

        OAuth2Template oAuth2Template = new ShopifyOAuth2Template(appId, appSecret,
            baseUrl + "authorize",
            baseUrl + "access_token");
        oAuth2Template.setUseParametersForClientAuthentication(true);
        return oAuth2Template;
    }

    private String getShopName() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String shopName = request.getParameter("shop_name");
        HttpSession session = request.getSession();
        if (shopName != null) {
            session.setAttribute(SHOP_NAME_SESS_ATTR, shopName);
        } else {
            shopName = (String) session.getAttribute(SHOP_NAME_SESS_ATTR);
        }
        return shopName;
    }

    public Map<String, Object> getApi(String accessToken) {
        return null;
    }

}
