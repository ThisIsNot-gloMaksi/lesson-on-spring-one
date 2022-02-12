package com.glomaksi.core.dao;


import com.glomaksi.core.bean.Json;
import com.glomaksi.core.entity.User;
import com.glomaksi.core.entity.UserList;

import java.io.*;
import java.util.List;
import java.util.Objects;

public class UserDaoImpl implements UserDao {
    private final BufferedReader reader;
    private BufferedWriter writer;
    private final File file;
    private final Json json = new Json();

    public UserDaoImpl(String name) throws FileNotFoundException {
        String path = Objects.requireNonNull(getClass()
                .getClassLoader().getResource(name)).getPath();

        file = new File(path);

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
    public List<User> getUser() throws IOException {
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
