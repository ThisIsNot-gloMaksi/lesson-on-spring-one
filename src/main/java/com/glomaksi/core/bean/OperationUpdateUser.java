package com.glomaksi.core.bean;

import com.glomaksi.core.entity.User;
import com.glomaksi.core.frontend.view.View;
import com.glomaksi.core.service.UserService;
import com.glomaksi.core.utils.ConvertToNull;
import com.glomaksi.core.utils.MenuRender;

import java.io.IOException;

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
            Integer id = ConvertToNull.getNumberOrNull(str);

            String newName = ConvertToNull.getNotEmptyOrNullValue(
                    view.getLine("Введите новое имя или нажмите <enter>"));

            String email = ConvertToNull.getNotEmptyOrNullValue(
                    view.getLine("Введите новый email или нажмите <enter>"));

            User user = null;

            if (id == null) {
                user = userService.updateUser(str, newName, email);

            } else {
                user = userService.updateUser(id, newName, email);
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
