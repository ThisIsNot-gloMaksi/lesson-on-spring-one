package com.glomaksi.core;

import com.glomaksi.core.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        UserService userService = context.getBean(UserService.class);
        userService.printUsers();
    }

}
