package com.example.proxy.cglib;

import com.example.proxy.jdk.TargetInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {

        //创建目标对象
        final Target target = new Target();

        //创建增强对象
        Advice advice = new Advice();

        //1.创建增强器
        Enhancer enhancer = new Enhancer();
        //2.设置父类(目标)
        enhancer.setSuperclass(Target.class);
        //3.设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                advice.before();//执行前置
                Object invoke = method.invoke(target, args);//执行目标
                advice.afterRunning();//执行后置
                return null;
            }
        });
        //4.生成代理对象
        Target proxy = (Target) enhancer.create();

        proxy.save();
    }
}
