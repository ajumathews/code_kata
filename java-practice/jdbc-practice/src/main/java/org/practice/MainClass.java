package org.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        DBExecutor dbExecutor = context.getBean(DBExecutor.class);
        System.out.println(dbExecutor.executeQuery());

    }
}
