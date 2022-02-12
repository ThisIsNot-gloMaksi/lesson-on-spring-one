package com.glomaksi.core.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.glomaksi.core.entity.UserList;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;


public class Json {
    private final ObjectMapper mapper = new ObjectMapper();


    public void write(UserList users, Writer writer) throws IOException {
        mapper.writeValue(writer, users);
    }

    public UserList read(Reader reader) throws IOException {
        UserList userList;
        try {
            userList = mapper.readValue(reader, UserList.class);
        } catch (MismatchedInputException e) {
            userList = new UserList(new ArrayList<>());
        }
        return userList;
    }
}
