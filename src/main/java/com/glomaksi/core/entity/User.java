package com.glomaksi.core.entity;

import com.glomaksi.core.utils.ListMenu;

public class User implements ListMenu {
    private int id;
    private String name;
    private int age;

    public User() {
    }

    public User(int id, String name, int age) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }


    @Override
    public String createNameForMenu() {
        return toString();
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
