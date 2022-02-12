package com.glomaksi.core.service;

import com.glomaksi.core.dao.UserDao;
import com.glomaksi.core.entity.User;
import com.glomaksi.core.event.Event;
import com.glomaksi.core.event.Observer;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public class UserServiceImpl implements UserService, Observer {
    private final UserDao userDao;
    private final List<User> users;
    private final Event event;

    public UserServiceImpl(UserDao userDao, Event event) {
        this.event = event;
        event.subscribe(this);
        this.userDao = userDao;
        users = getUsers();
    }


    @Override
    public void saveUsers(List<User> users) {
        try {
            userDao.save(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUsers() {
        if (users == null) {
            try {
                return userDao.getUser();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return users;
    }

    @Override
    public User getUserById(int id) {
        return templateSearchUser(it -> it.getId() == id);
    }

    @Override
    public User getUserByName(String name) {
        return templateSearchUser(it -> it.getName().equals(name.trim()));
    }

    private User templateSearchUser(Predicate<User> predicate) {
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    @Override
    public User deleteUser(int id) {
        User user = getUserById(id);
        return templateUserDelete(user);
    }

    @Override
    public User deleteUserByName(String name) {
        User user = getUserByName(name);
        return templateUserDelete(user);
    }

    private User templateUserDelete(User user) {
        if (user == null) {
            return null;
        }
        users.remove(user);
        return user;
    }

    @Override
    public User updateUser(int id, String name, String email) {
        User user = getUserById(id);
        return templateUpdateUser(user, name, email);
    }

    @Override
    public User updateUser(@NotNull String oldName, String newName, String email) {
        User user = getUserByName(oldName);
        return templateUpdateUser(user, newName, email);
    }

    private User templateUpdateUser(User user, String name, String email) {
        if (user == null) {
            return null;
        }
        if (name != null && !user.getName().equals(name)) {
            user.setName(name);
        }

        if (email != null && !email.equals(user.getEmail())) {
            user.setEmail(email);
        }
        return user;
    }

    @Override
    public boolean addUser(User user) {
        return users.add(user);
    }

    @Override
    public void updateState() {
        close();
    }

    @Override
    public void close() {
        saveUsers(users);
        userDao.close();
        event.unsubscribe(this);
    }
}
