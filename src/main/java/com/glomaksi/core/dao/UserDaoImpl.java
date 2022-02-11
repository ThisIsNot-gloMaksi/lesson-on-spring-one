package com.glomaksi.core.dao;


import com.glomaksi.core.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDaoImpl implements UserDao {
    private BufferedReader reader;
    private BufferedWriter writer;

    public UserDaoImpl(String p) {
        try {
            String path = Objects.requireNonNull(getClass().getClassLoader().getResource(p)).getFile();
            reader = new BufferedReader(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(List<User> users) throws IOException {
    }

    @Override
    public List<User> getUser() throws IOException {
        List<User> users = new ArrayList<>();
        while (reader.ready()) {
            String[] str = reader.readLine().split(" ");
            users.add(new User(str[0], Integer.parseInt(str[1])));
        }
        return users;
    }
}
