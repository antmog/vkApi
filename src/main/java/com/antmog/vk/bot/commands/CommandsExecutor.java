package com.antmog.vk.bot.commands;

import java.util.function.Consumer;

public class CommandsExecutor {
    public static <T> void execute(Consumer<T> consumer, T paramsObject) {
        try {
            consumer.accept(paramsObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> void execute(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
