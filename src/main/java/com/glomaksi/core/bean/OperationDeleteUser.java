package com.glomaksi.core.bean;

import com.glomaksi.core.entity.User;
import com.glomaksi.core.frontend.view.View;
import com.glomaksi.core.service.UserService;
import com.glomaksi.core.utils.MenuRender;
import com.glomaksi.core.utils.OptionalGenerator;

import java.io.IOException;
import java.util.Optional;

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
            String str = view.getLine("Введите имя или id пользователя");
            Optional<Integer> id = OptionalGenerator.getOptionalForNumberValue(str);
            User user;

            if (id.isPresent()) {
                user = userService.deleteUser(id.get());
            } else {
                user = userService.deleteUserByName(str);
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
