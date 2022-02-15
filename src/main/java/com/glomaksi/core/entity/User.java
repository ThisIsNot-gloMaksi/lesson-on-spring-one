package com.glomaksi.core.entity;

import com.glomaksi.core.utils.ListMenu;

public class User implements ListMenu {
    private int id;
    private String name;
    private String email;

    public User() {
    }

    public User(int id, String name, String email) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String createNameForMenu() {
        return toString();
    }

    @Override
    public String toString() {
        return "id: "+ id + " name: " + name + " email: " + email;
    }
}
