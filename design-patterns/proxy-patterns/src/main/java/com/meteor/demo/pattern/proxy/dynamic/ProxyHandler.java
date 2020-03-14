package com.meteor.demo.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created  bhy on 2020/3/14
 *   jdk的动态代理是使用 反射作为代理的条件
 **/
public class ProxyHandler implements InvocationHandler {

    private Object object;

    public ProxyHandler(Object o){
        this.object =o;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "  + method.getName());
        method.invoke(object, args);
        System.out.println("After invoke " + method.getName());
        return null;
    }
}
