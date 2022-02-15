package com.glomaksi.core.dao;

import com.glomaksi.core.entity.UserList;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


public interface Json {

   void write(UserList users, Writer writer) throws IOException;

   UserList read(Reader reader) throws IOException;
}
