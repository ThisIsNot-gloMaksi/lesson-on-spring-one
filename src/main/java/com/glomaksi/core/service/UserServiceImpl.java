package com.glomaksi.core.service;

import com.glomaksi.core.dao.UserDao;
import com.glomaksi.core.entity.User;
import com.glomaksi.core.event.Event;
import com.glomaksi.core.event.Observer;

import java.io.IOException;
import java.util.List;

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

    private User findUserById(int id) {
        return users.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
    }

    @Override
    public User deleteUser(int id) {
        User user = findUserById(id);
        if (user == null) {
            return null;
        }
        users.remove(user);
        return user;
    }

    private User setUser(int userId, String name, int age) {
        User user = findUserById(userId);
        if (user == null) {
            return null;
        }
        if (name != null && !user.getName().equals(name)) {
            user.setName(name);
        }

        if (age != -1 && user.getAge() != age) {
            user.setAge(age);
        }
        return user;
    }

    @Override
    public User updateUser(int id, String name) {
        return setUser(id, name, -1);
    }

    @Override
    public User updateUser(int id, String name, int age) {
        return setUser(id, name, age);
    }

    @Override
    public User updateUser(int id, int age) {
        return setUser(id, null, age);
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
