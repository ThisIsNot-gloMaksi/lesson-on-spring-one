package com.glomaksi.core.service;

import com.glomaksi.core.dao.UserDao;
import com.glomaksi.core.entity.User;

import java.io.IOException;
import java.util.List;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void printUsers() {
        try {
            List<User> list = userDao.getUser();
            for (User user : list) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
