package com.antmog.vk.bot.service;

import com.antmog.vk.bot.commands.CommandsExecutor;
import com.antmog.vk.bot.commands.group.GroupCommands;
import com.antmog.vk.bot.config.ProjectSettings;
import com.antmog.vk.bot.model.command.group.GroupCommandParams;
import com.vk.api.sdk.objects.wall.responses.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VkService {

    @Autowired
    private GroupCommands groupCommands;
    @Autowired
    private ProjectSettings conf;

    public void doSomething() {
        // Integer groupId = conf.getSalovaGroupId();
        Integer groupId = conf.getMyGroupId();

        GroupCommandParams getPostsParams = GroupCommandParams.builder()
                .ownerId(groupId)
                .count(5)
                .build();
        GetResponse getResponse = CommandsExecutor.execute(groupCommands.getPostsCommandFunction, getPostsParams);

        if (getResponse == null) {
            throw new IllegalStateException("Null response after request!");
        }

        Integer postId = getResponse.getItems().get(0).getId();
        GroupCommandParams params = GroupCommandParams.builder()
                .ownerId(groupId)
                .postId(postId)
                .message("test msg")
                .build();

        CommandsExecutor.execute(groupCommands.createCommentCommandConsumer, params);
    }

    public void getPostsFromSalovaBasketBallGroup() {
        GroupCommandParams params = GroupCommandParams.builder()
                .ownerId(conf.getSalovaGroupId())
                .count(5)
                .build();

        CommandsExecutor.execute(groupCommands.getPostsCommandConsumer, params);
    }
}
