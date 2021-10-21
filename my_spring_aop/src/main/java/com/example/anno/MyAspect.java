package com.example.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect //标注当前MyAspect是切面
public class MyAspect {

    //配置前置增强
    @Before("execution(* com.example.anno.*.*(..))")
    public void before(){
        System.out.println("前置增强.......");
    }

    public void afterReturning() {
        System.out.println("后置增强......");
    }

    /**
     * pjp:正在执行的连接点==切点
     * @param pjp
     */
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强....");
        //切点方法
        Object proceed = pjp.proceed();
        System.out.println("环绕前增强....");
        return proceed;
    }

    public void afterThrowing() {
        System.out.println("异常抛出增强......");
    }

    public void after() {
        System.out.println("最终增强......");
    }
}
