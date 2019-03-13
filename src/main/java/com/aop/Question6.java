package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class Question6 {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        MyIOException myIOException = ctx.getBean(MyIOException.class);
        try {
            myIOException.method1();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        try {
            myIOException.method2();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }


}

@Component
class MyIOException {

    void method1() throws IOException {
        throw new IOException("IOException1");
    }

    void method2() throws IOException {
        throw new IOException("IOException2");
    }

}

@Component
@Aspect
class ExceptionAspect {

    @AfterThrowing(pointcut = "execution(* com.aop.MyIOException.*())", throwing = "error")
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable error) {
        System.out.println("Method Signature: " + joinPoint.getSignature());
        System.out.println("Exception: " + error);
    }
}
