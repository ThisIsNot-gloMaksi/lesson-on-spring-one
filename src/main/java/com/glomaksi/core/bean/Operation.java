package com.glomaksi.core.bean;

import com.glomaksi.core.utils.ListMenu;

public interface Operation extends ListMenu {
    void execute();

    String getName();

    default String createNameForMenu() {
        return getName();
    }

}
