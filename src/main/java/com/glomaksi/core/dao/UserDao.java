package com.glomaksi.core.dao;

import com.glomaksi.core.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    void save(List<User> user) throws IOException;

    List<User> getUser() throws IOException;

    void close();
}
