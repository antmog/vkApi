package com.antmog.vk.bot;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class VkApi {

    private VkApiClient vk;

    @PostConstruct
    public void init() {
        TransportClient transportClient = new HttpTransportClient();
        vk = new VkApiClient(transportClient);
    }

    public VkApiClient getClient() {
        return vk;
    }
}
