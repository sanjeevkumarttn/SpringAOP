package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Question5 {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        Student student = ctx.getBean(Student.class);
        student.setRollNumber(12);
        student.setName("Peter");
        student.setMarks(87.9f);
        student.studentInfo();

    }
}

@Component
class Student {
    private int rollNumber;
    private String name;
    private float marks;

    void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    void setName(String name) {
        this.name = name;
    }

    void setMarks(float marks) {
        this.marks = marks;
    }

    void studentInfo() {
        System.out.println("Name: " + name + " Roll Number: " + rollNumber + " Marks: " + marks);
    }
}

@Aspect
class StudentAspect {

    @Before("execution(void studentInfo())")
    void beforeAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature() + " Started..");
    }

    @After("execution(void studentInfo())")
    void afterAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature() + " Stopped..");
    }
}

