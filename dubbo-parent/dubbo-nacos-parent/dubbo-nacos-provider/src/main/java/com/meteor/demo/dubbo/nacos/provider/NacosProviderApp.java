package com.meteor.demo.dubbo.nacos.provider;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by Meteor on 2019/12/29
 */
public class NacosProviderApp {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-provider.xml");
        context.start();
        System.in.read();
    }



}
