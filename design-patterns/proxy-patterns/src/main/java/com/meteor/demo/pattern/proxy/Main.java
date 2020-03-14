package com.meteor.demo.pattern.proxy;

import com.meteor.demo.pattern.proxy.dynamic.CglibProxyHanlder;
import com.meteor.demo.pattern.proxy.dynamic.ProxyHandler;
import com.meteor.demo.pattern.proxy.sample.ITestDao;
import com.meteor.demo.pattern.proxy.sample.TestDao;
import com.meteor.demo.pattern.proxy.sample.TestService;
import com.meteor.demo.pattern.proxy.sample.TestServiceImpl;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created  bhy on 2020/3/14
 *  spring aop 采用了jdk的动态代理 及cglib的动态代理。。所以我这里引入了spring aop的包一样可以使用
 *  spring aop 代理决策
 *  当对象有实现接口则使用jdk 代理，如果没有则使用cglib 进行代理
 **/
public class Main {

    public static void main(String[] args) {
        Main main =new Main();
//        main.stateProxyMock();

//        main.jdkProxyMock();

        main.cglibProxyMock();

    }


    /**
     *  静态代理 模拟
     *  静态代理的本质就是在屏蔽的目标实现，并在这基础上进行扩展封装
     *  做到隔绝 类类之间的直接耦合
     */
    private  void  stateProxyMock(){
        TestDao dao =new ITestDao();
        TestService service =new TestServiceImpl(dao);
        service.testSay("aaa");
    }

    /**
     * 使用jdk反射实现代理模式  虽然也能包住整个目标类 ，但是在书写及使用上带来很多限制。
     */
    private void  jdkProxyMock(){
        TestDao dao =new ITestDao();
        InvocationHandler handler  = new ProxyHandler(dao);
        TestDao jdkProxy  = (TestDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(),handler);
        jdkProxy.say("test");
    }

    /**
     * cglib 可以对实例类进行代理
     */
    private void  cglibProxyMock(){
        //实例化一个增强器，也就是cglib中的一个class generator
        Enhancer enhancer = new Enhancer();
        //设置目标类
        enhancer.setSuperclass(ITestDao.class);
        //设置拦截对象
        CglibProxyHanlder hanlder = new CglibProxyHanlder();
        enhancer.setCallback(hanlder);
        TestDao dao  = (TestDao) enhancer.create();
        dao.say("6666");


    }


}
