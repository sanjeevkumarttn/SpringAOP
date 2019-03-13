package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Question4 {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        AccountService accountService = ctx.getBean(AccountService.class);
        accountService.setBalance(10000);
        System.out.println("Balance is: " + accountService.getBalance());
    }
}

@Component
@Aspect
class Logger {
    @Before("execution( * com.aop.AccountService.*(..))")
    void beforeAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature() + " started..");
    }
}

@Component
class AccountService {

    //@Value("10000")
    int balance;

    int getBalance() {
        return balance;
    }

    void setBalance(int balance) {
        this.balance = balance;
    }
}
