package com.glomaksi.core.dao;

import com.glomaksi.core.entity.User;
import com.glomaksi.core.entity.UserList;

import java.io.*;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final BufferedReader reader;
    private BufferedWriter writer;
    private final File file;
    private final Json json;

    public UserDaoImpl(String name, Json json) throws IOException {
        this.json = json;
        file = new File(name);
        if (!file.exists()) {
            file.createNewFile();
        }
        reader = new BufferedReader(new FileReader(file));
    }

    @Override
    public void save(List<User> users) throws IOException {
        if (writer == null) {
            writer = new BufferedWriter(new FileWriter(file));
        }
        json.write(new UserList(users), writer);
    }

    @Override
    public List<User> getUsers() throws IOException {
        return json.read(reader).getUsers();
    }

    @Override
    public void close() {
        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
