package com.sivaram.so.util;

import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

@UtilityClass
public class RetryUtils {

    public static String trimValue(String value) {
        return executeNullBasedExecutor(value, String::trim);
    }

    public static <I, O> O executeNullBasedExecutor(I value, Function<I, O> nonNullExecutor, Supplier<O> nullExecutor) {
        return value != null ? nonNullExecutor.apply(value) : nullExecutor.get();
    }

    public static <I, O> O executeNullBasedExecutor(I value, Function<I, O> nonNullExecutor) {
        return value != null ? nonNullExecutor.apply(value) : null;
    }

    public static boolean hasText(String value) {
        return executeNullBasedExecutor(value, val -> !val.trim().isEmpty(), () -> false);
    }
    
}
