package com.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class Question7 {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        EmailService mailService = ctx.getBean(EmailService.class);
        mailService.sendMail();

    }
}


@Service
class EmailService {
    void sendMail() {
        System.out.println(">>>>>>>>>>>mail send...");
    }

}


@Component
@Aspect
class AspectForExpressions {
    @Before("execution(void sendMail(..))")
    void beforeAspect() {
        System.out.println("---Before execution Aspect---");
    }

    @After("execution(void sendMail(..))")
    void afterAspect() {
        System.out.println("---After execution Aspect---");
    }

    @Before("within(com.aop.EmailService)")
    void withinBeforeAspect() {
        System.out.println("---Before within Aspect---");
    }

    @After("within(com.aop.EmailService)")
    void withinAfterAspect() {
        System.out.println("---After within Aspect---");
    }

    @Before("bean(mailService))")
    void beanBeforeAdvice() {
        System.out.println("---Before Bean advice---");
    }

    @After("bean(mailService))")
    void beanAfterAdvice() {
        System.out.println("---After Bean advice---");
    }

    @Before("args()")
    void argsBeforeAdvice() {
        System.out.println("---Before Args advice---");
    }

    @After("args()")
    void argsAfterAdvice() {
        System.out.println("---After Args advice---");
    }

    @Before("this(com.aop.EmailService)")
    void thisBeforeAdvice() {
        System.out.println("---Before this advice---");
    }

    @After("this(com.aop.EmailService)")
    void thisAfterAdvice() {
        System.out.println("---After this advice---");
    }
}