package com.glomaksi.core;

import com.glomaksi.core.frontend.Frontend;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("main.xml");
        Frontend frontend = context.getBean(Frontend.class);
        frontend.run();
    }

}
