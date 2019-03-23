package com.antmog.vk.bot.commands.group;

import com.antmog.vk.bot.config.ProjectSettings;
import com.antmog.vk.bot.model.command.group.GroupCommandParams;
import com.antmog.vk.bot.thirdparty.VkApi;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

import static com.antmog.vk.bot.utils.FunctionUtils.throwingConsumerWrapper;
import static com.antmog.vk.bot.utils.FunctionUtils.throwingRunnableWrapper;

@Service
public class GroupCommands {

    @Autowired
    private ProjectSettings conf;
    @Autowired
    private VkApi vkApi;

    public Runnable getFirstFivePostsCommand = throwingRunnableWrapper(() -> {
        // TODO: 23.03.2019 do smth with response
        GetResponse getResponse = vkApi.getVk().wall().get(vkApi.getActor())
                .ownerId(conf.getSalovaGroupId())
                .count(5)
                .execute();
    });

    public Consumer<GroupCommandParams> getPostsCommand = throwingConsumerWrapper(params -> {
        // TODO: 23.03.2019 do smth with response
        GetResponse getResponse = vkApi.getVk().wall().get(vkApi.getActor())
                .ownerId(params.getOwnerId())
                .count(params.getCount())
                .offset(params.getOffset())
                .execute();
    });
}
