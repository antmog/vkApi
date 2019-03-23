package com.antmog.vk.bot.commands.group;

import com.antmog.vk.bot.config.ProjectSettings;
import com.antmog.vk.bot.model.command.group.GroupCommandParams;
import com.antmog.vk.bot.thirdparty.VkApi;
import com.vk.api.sdk.objects.wall.responses.CreateCommentResponse;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;
import java.util.function.Function;

import static com.antmog.vk.bot.utils.FunctionUtils.*;

@Service
public class GroupCommands {

    @Autowired
    private ProjectSettings conf;
    @Autowired
    private VkApi vkApi;

    public Runnable getFirstFivePostsCommandRunnable = throwingRunnableWrapper(() -> {
        // TODO: 23.03.2019 do smth with response
        GetResponse getResponse = vkApi.getVk().wall().get(vkApi.getActor())
                .ownerId(conf.getSalovaGroupId())
                .count(5)
                .execute();
    });

    public Consumer<GroupCommandParams> getPostsCommandConsumer = throwingConsumerWrapper(params -> {
        // TODO: 23.03.2019 do smth with response
        GetResponse getResponse = vkApi.getVk().wall().get(vkApi.getActor())
                .ownerId(params.getOwnerId())
                .count(params.getCount())
                .offset(params.getOffset())
                .execute();
    });

    public Function<GroupCommandParams, GetResponse> getPostsCommandFunction = throwingFunctionWrapper(
            params -> vkApi.getVk().wall().get(vkApi.getActor())
                    .ownerId(params.getOwnerId())
                    .count(params.getCount())
                    .offset(params.getOffset())
                    .execute());

    public Consumer<GroupCommandParams> createCommentCommandConsumer = throwingConsumerWrapper(params -> {
        // TODO: 23.03.2019 do smth with response
        CreateCommentResponse getResponse = vkApi.getVk().wall().createComment(vkApi.getActor(), params.getPostId())
                .ownerId(params.getOwnerId())
                .message(params.getMessage())
                .execute();
    });
}
