package com.glomaksi.core.bean;

import com.glomaksi.core.entity.User;
import com.glomaksi.core.frontend.view.View;
import com.glomaksi.core.service.UserService;
import com.glomaksi.core.utils.ConvertToNull;
import com.glomaksi.core.utils.MenuRender;

import java.io.IOException;

public class OperationDeleteUser implements Operation {
    private final UserService userService;
    private final View view;

    public OperationDeleteUser(UserService userService, View view) {
        this.userService = userService;
        this.view = view;
    }

    @Override
    public void execute() {
        try {
            view.print(MenuRender.getMenu(userService.getUsers()));
            String name = view.getLine("Введите имя или id пользователя");
            Integer id = ConvertToNull.getNumberOrNull(name);
            User user = null;

            if (id == null) {
                user = userService.deleteUserByName(name);

            } else {
                user = userService.deleteUser(id);
            }

            if (user == null) {
                view.println("Операция невыполнена");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getName() {
        return "Удалить пользователя";
    }
}
