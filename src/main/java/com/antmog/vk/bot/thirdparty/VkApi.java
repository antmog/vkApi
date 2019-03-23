package com.antmog.vk.bot.thirdparty;

import com.antmog.vk.bot.config.ProjectSettings;
import com.antmog.vk.bot.service.VkApiInitialisationService;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
public class VkApi {

    private final static String CONTENT_TYPE = "text/html;charset=utf-8";

    private VkApiClient vk;
    private UserActor actor;

    @Autowired
    private ProjectSettings conf;
    @Autowired
    private VkApiInitialisationService vkApiInitialisationService;

    @PostConstruct
    public void init() {
        TransportClient transportClient = new HttpTransportClient();
        vk = new VkApiClient(transportClient);
    }

    public void setActor(String code) {
        try {
            tryToSetActor(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tryToSetActor(String code) throws Exception {
        // only 1 try for each code value, redirect url with http(s)
        UserAuthResponse authResponse = vk.oauth()
                .userAuthorizationCodeFlow(conf.getApplicationId(), conf.getProtectedKey(), vkApiInitialisationService.getRedirectUrl(), code)
                .execute();

        actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
    }
}
