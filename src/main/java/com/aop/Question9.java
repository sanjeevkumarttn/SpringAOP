package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Question9 {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        JoinPointExample joinPointExample = ctx.getBean(JoinPointExample.class);
        joinPointExample.joinPointMethod("first");
        joinPointExample.joinPointMethod("second");
    }
}

@Component
class JoinPointExample {

    void joinPointMethod(String methodCall){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>This is "+methodCall+" method call");

    }
}

@Component
@Aspect
class JoinPointExampleAspect {

    @Before("execution(void joinPointMethod(String))")
    void beforeAdvice(JoinPoint joinPoint) {
        System.out.println(">>>>>>>>>>>>Running before advice");
        System.out.println(">>>>>>>>>>>>>>"+joinPoint.getSignature());
        Object [] objects=joinPoint.getArgs();
        for (Object object:objects){
            System.out.println("Argument: >>>>>>>>>>>>>>"+object);
        }
    }
}
