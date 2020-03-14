package com.meteor.demo.spring.context;

import com.meteor.demo.spring.context.conf.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created  bhy on 2020/3/12
 *  这里只展示手动装载
 *   spring 容器的创建手段 及applicationContext
 *
 *  AnnotationConfigApplicationContext：从一个或多个基于Java的配置类中加载Spring应用上下文。（我们一般配置的注解去加载方式）
 *  AnnotationConfigWebApplicationContext：从一个或多个基于Java的配置类中加载Spring Web应用上下文。 ()
 *  ClassPathXmlApplicationContext：从类路径下的一个或多个XML配置文件中加载上下文定义，把应用上下文的定义文件作为类资源。(我们常用的简单加载方式)
 *  FileSystemXmlapplicationcontext：从文件系统下的一个或多个XML配置文件中加载上下文定义。
 *  XmlWebApplicationContext：从Web应用下的一个或多个XML配置文件中加载上下文定义。
 *
 *  当spring 也就是applicationContext 加载完后，我们可以利用getBean 获取到我们注册的bean  B
 **/
public class SpringContext {


    /**
     * 文件系统位置加载
     *  通过系统绝对地址加载配置文件
     */
    public void fileSystemLoad(){
        ApplicationContext context = new FileSystemXmlApplicationContext("c:/xxx.xml");

    }

    /**
     *  应用层加载
     *  通过项目的相对路径加载系统配置
     */
    public void classPathLoad(){
        ApplicationContext context =new ClassPathXmlApplicationContext("spring/dubbo-provider.xml");
    }

    /**
     *  直接加载bean的方式
     */
    public void beanLoad(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    }
}
