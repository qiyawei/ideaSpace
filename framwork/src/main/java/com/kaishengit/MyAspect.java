package com.kaishengit;

public class MyAspect {
    //前置通知
    public void beforeAdvice(){
        System.out.println("前置通知");
    }
    public void afterReturning(Object object){
        System.out.println("后置通知" + object);
    }
    public void throwAdvice(Exception ex){
        System.out.println("异常通知" + ex.getMessage());
    }
    public void finalAdvice(){
        System.out.println("最终通知");
    }
}
