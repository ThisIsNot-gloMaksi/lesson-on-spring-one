package com.glomaksi.core.bean;

import com.glomaksi.core.entity.User;
import com.glomaksi.core.consoleClient.view.View;
import com.glomaksi.core.service.UserService;
import com.glomaksi.core.utils.MenuRender;

import java.io.IOException;
import java.util.List;

public class OperationShowUser implements Operation {
    private final UserService userService;
    private final View view;

    public OperationShowUser(UserService userService, View view) {
        this.userService = userService;
        this.view = view;
    }

    @Override
    public void execute() {
        try {
            List<User> users = userService.getUsers();
            view.println(MenuRender.getMenu(users));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "Посмотреть пользователей";
    }
}
