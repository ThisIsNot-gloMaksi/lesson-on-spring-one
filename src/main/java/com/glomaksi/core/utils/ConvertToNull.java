package com.glomaksi.core.utils;

import org.jetbrains.annotations.NotNull;

public class ConvertToNull {
    public static String getNotEmptyOrNullValue(@NotNull String str) {
        if (str.length() > 0) {
            return str;
        }
        return null;
    }

    public static Integer getNumberOrNull(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
