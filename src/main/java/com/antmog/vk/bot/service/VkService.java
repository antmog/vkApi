package com.antmog.vk.bot.service;

import com.antmog.vk.bot.commands.CommandsExecutor;
import com.antmog.vk.bot.commands.group.GroupCommands;
import com.antmog.vk.bot.config.ProjectSettings;
import com.antmog.vk.bot.model.command.group.GroupCommandParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VkService {

    @Autowired
    private GroupCommands groupCommands;
    @Autowired
    private ProjectSettings conf;

    public void doSmth() {
        GroupCommandParams params = GroupCommandParams.builder()
                .ownerId(conf.getSalovaGroupId())
                .count(5)
                .build();

        CommandsExecutor.execute(groupCommands.getPostsCommand, params);
    }
}
