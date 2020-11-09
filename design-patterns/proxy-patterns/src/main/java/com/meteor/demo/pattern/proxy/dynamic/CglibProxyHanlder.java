package com.meteor.demo.pattern.proxy.dynamic;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created  bhy on 2020/3/14
 *  cglib代理方式
 **/
public class CglibProxyHanlder  implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String sortName = method.getName();
        long start = System.currentTimeMillis();
        //此处一定要使用proxy的invokeSuper方法来调用目标类的方法
        methodProxy.invokeSuper(object, objects);
        long end = System.currentTimeMillis();
        System.out.println("本次" + sortName + "的执行时间为: " + (end - start) + "ms");
        return null;
    }
}
