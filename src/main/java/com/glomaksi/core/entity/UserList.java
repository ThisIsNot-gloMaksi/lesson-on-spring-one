package com.glomaksi.core.entity;

import java.util.List;

public class UserList {
    private List<User> users;

    public UserList() {
    }

    public UserList(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "users=" + users +
                '}';
    }
}
