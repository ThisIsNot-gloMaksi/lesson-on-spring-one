package com.glomaksi.core.utils;

import java.util.Optional;
import java.util.regex.Pattern;

public class OptionalGenerator {
    private static final Pattern pattern;
    static {
        String regex = "[^0-9]";
        pattern = Pattern.compile(regex);
    }

    public static Optional<Integer> getOptionalForNumberValue(String text) {
        if (pattern.matcher(text).matches()) {
            return Optional.empty();
        }
        return Optional.of(Integer.parseInt(text));
    }
}
