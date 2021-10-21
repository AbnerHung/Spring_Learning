package com.example.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {

        //创建目标对象
        final Target target = new Target();

        //创建增强对象
        Advice advice = new Advice();

        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), //目标对象类加载器
                target.getClass().getInterfaces(),//目标对象相同发接口字节码对象
                new InvocationHandler() {
                    //调用代理对象的任何方法，执行的实质都是invoke方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //前置增强
                        advice.before();
                        Object invoke = (method.invoke(target, args));//执行目标方法
                        //后置增强
                        advice.afterRunning();
                        return invoke;
                    }
                }
        );
        //调用代理对象的方法
        proxy.save();
    }
}
