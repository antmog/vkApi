package com.antmog.vk.bot.utils;

import com.antmog.vk.bot.model.function.ThrowingConsumer;
import com.antmog.vk.bot.model.function.ThrowingRunnable;

import java.util.function.Consumer;

public class FunctionUtils {
    public static <T> Consumer<T> throwingConsumerWrapper(
            ThrowingConsumer<T, Exception> throwingConsumer) {

        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    public static <T> Runnable throwingRunnableWrapper(
            ThrowingRunnable<Exception> throwingRunnable) {

        return () -> {
            try {
                throwingRunnable.run();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }
}
