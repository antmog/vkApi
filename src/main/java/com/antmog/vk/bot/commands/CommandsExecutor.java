package com.antmog.vk.bot.service;

import java.util.function.Consumer;

public class CommandsExecutor {
    public void execute(Consumer consumer) {
        try {
            consumer.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
