package com.glomaksi.core.utils;


import java.util.List;

public class MenuRender {
    public static String getMenu(List<? extends ListMenu> operations) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < operations.size(); i++) {
            builder.append(i + 1)
                    .append(". ")
                    .append(operations.get(i).createNameForMenu())
                    .append(".\n");
        }
        return builder.toString();
    }
}
