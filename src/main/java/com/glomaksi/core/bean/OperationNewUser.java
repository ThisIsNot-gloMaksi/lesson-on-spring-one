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
            int age = 0;
            boolean ageIsCorrect = false;
            while (!ageIsCorrect) {
                try {
                    age = view.getNumber("Введите возраст");
                    if (age > 0) {
                        ageIsCorrect = true;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e) {
                    view.println("Введите корректный возраст");
                }
            }
            int id = userService.getUsers().size();
            userService.addUser(new User(id + 1, name, age));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getName() {
        return "Создать нового пользователя";
    }
}
