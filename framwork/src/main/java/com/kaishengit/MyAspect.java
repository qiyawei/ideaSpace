package com.kaishengit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import javax.inject.Named;

//@Named
//@Aspect
public class MyAspect {
    @Pointcut("execution(* com.kaishengit.spring.dao..*.*(..))")
    public void pointcut(){}
    //前置通知
    @Before("pointcut()")
    public void beforeAdvice(){
        System.out.println("前置通知");
    }
    @AfterReturning(value = "pointcut()" ,returning = "object")
    public void afterReturning(Object object){
        System.out.println("后置通知" + object);
    }
    @AfterThrowing(value = "pointcut()",throwing = "ex")
    public void throwAdvice(Exception ex){
        System.out.println("异常通知  " + ex.getMessage());
    }
    @After("pointcut()")
    public void finalAdvice(){
        System.out.println("最终通知");
    }
    @Around("pointcut()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {

        try {
            System.out.println("环绕前置通知....");
            Object obj = joinPoint.proceed();//代表目标对象的方法执行
            throw new Exception("出异常了");
           // System.out.println("环绕后置通知.... : " + obj);
        } catch (Throwable throwable) {
            System.out.println("环绕异常通知....:" + throwable.getMessage());
        } finally {
            System.out.println("环绕最终通知....");
        }

    }



}
