package com.glomaksi.core.bean;

import com.glomaksi.core.entity.User;
import com.glomaksi.core.frontend.view.View;
import com.glomaksi.core.service.UserService;
import com.glomaksi.core.utils.MenuRender;
import com.glomaksi.core.utils.OptionalGenerator;

import java.io.IOException;
import java.util.Optional;

public class OperationUpdateUser implements Operation {
    private final UserService userService;
    private final View view;

    public OperationUpdateUser(UserService userService, View view) {
        this.userService = userService;
        this.view = view;
    }

    @Override
    public void execute() {
        try {
            view.print(MenuRender.getMenu(userService.getUsers()));
            String str = view.getLine("Введите имя или id пользователя");
            Optional<Integer> id = OptionalGenerator.getOptionalForNumberValue(str);

            String newName = view.getLine("Введите новое имя или нажмите <enter>");

            String email = view.getLine("Введите новый email или нажмите <enter>");

            User user;

            if (id.isPresent()) {
                user = userService.updateUser(id.get(), newName, email);

            } else {
                user = userService.updateUser(str, newName, email);
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
        return "Изменить пользователя";
    }
}
