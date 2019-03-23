package com.antmog.vk.bot.service.group;

import com.antmog.vk.bot.config.ProjectSettings;
import com.antmog.vk.bot.thirdparty.VkApi;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

import static com.antmog.vk.bot.utils.FunctionUtils.throwingConsumerWrapper;

@Service
public class GroupService {

    @Autowired
    private ProjectSettings conf;
    @Autowired
    private VkApi vkApi;

    public Consumer getPostsCommand = throwingConsumerWrapper(i -> {
        GetResponse getResponse = vkApi.getVk().wall().get(vkApi.getActor())
                .ownerId(conf.getSalova())
                .count(5)
                .offset(5)
                .execute();
    });
}
