package com.aop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Question1 {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        Employee employee = ctx.getBean("employee", Employee.class);
        System.out.println(">>>>>>>>Name: " + employee.getName() + " Id: " + employee.getId());
        ctx.start();
        ctx.stop();
        ctx.close();
    }

}

class Employee {
    private int id;
    private String name;

    int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}