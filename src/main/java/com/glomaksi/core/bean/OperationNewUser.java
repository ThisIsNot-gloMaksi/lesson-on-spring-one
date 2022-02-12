package com.glomaksi.core.bean;

import com.glomaksi.core.entity.User;
import com.glomaksi.core.frontend.view.View;
import com.glomaksi.core.service.UserService;

import java.io.IOException;

public class OperationNewUser implements Operation {
    private final View view;
    private final UserService userService;

    public OperationNewUser(View view, UserService userService) {
        this.view = view;
        this.userService = userService;
    }

    @Override
    public void execute() {
        try {
            String name = view.getLine("Введите имя: ");
            String email = view.getLine("Введите эмайл");
            int id = userService.getUsers().size();
            userService.addUser(new User(id + 1, name, email));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getName() {
        return "Создать нового пользователя";
    }
}
