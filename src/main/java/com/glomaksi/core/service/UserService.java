package com.glomaksi.core.service;

import com.glomaksi.core.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void saveUsers(List<User> users);

    List<User> getUsers();

    User getUserById(int id);

    User getUserByName(String name);

    User deleteUser(int id);

    User deleteUserByName(String name);

    User updateUser(int id, String name, String email);

    User updateUser(String oldName, String newName, String email);

    boolean addUser(User user);

    void close();

}
