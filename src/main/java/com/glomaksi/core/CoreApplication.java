package com.glomaksi.core;

import com.glomaksi.core.consoleClient.ConsoleClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("main.xml");
        ConsoleClient consoleClient = context.getBean(ConsoleClient.class);
        consoleClient.run();
    }

}
