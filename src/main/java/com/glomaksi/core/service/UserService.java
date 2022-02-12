package com.glomaksi.core.service;

import com.glomaksi.core.entity.User;

import java.util.List;

public interface UserService {

    void saveUsers(List<User> users);

    List<User> getUsers();

    User deleteUser(int id);

    User updateUser(int id, String name);

    User updateUser(int id, int age);

    User updateUser(int id, String name, int age);

    boolean addUser(User user);

    void close();
}
