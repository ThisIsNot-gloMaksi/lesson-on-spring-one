package com.glomaksi.core.dao;

import com.glomaksi.core.entity.User;
import com.glomaksi.core.utils.Close;

import java.io.IOException;
import java.util.List;

public interface UserDao extends Close {
    void save(List<User> user) throws IOException;

    List<User> getUsers() throws IOException;
}
