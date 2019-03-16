package com.antmog.vk.bot;

import com.vk.api.sdk.client.VkApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VkService {

    private static final String GET_CODE_URL = "https://oauth.vk.com/authorize?client_id=6902555&display=page&redirect_uri=localhost:8080/setcode&scope=friends&response_type=code&v=5.92";

    @Autowired
    private VkApi vkApi;
    @Autowired
    private YAMLConfig conf;

    public void auth() {
        VkApiClient vk = vkApi.getClient();
//        UserAuthResponse authResponse = vk.oauth()
//                .userAuthorizationCodeFlow(conf.getClientId(), conf.getClientSecret(), getRedirectUri(), code)
//                .execute();
//
//        UserActor actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
    }

    private String getOAuthUrl() {
        return "https://oauth.vk.com/authorize?client_id=" + conf.getClientId() + "&display=page&redirect_uri=" + getRedirectUri() + "&scope=groups&response_type=code";
    }

    private String getRedirectUri() {
        return conf.getServerName() + "/callback";
    }

    public String getGetCodeUrl() {
        return GET_CODE_URL;
    }
}
