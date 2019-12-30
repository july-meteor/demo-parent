package com.meteor.demo.dubbo.zk.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by Meteor on 2019/12/29
 *   使用zookeeper作为注册中心
 */
public class ZkProviderApp {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-provider.xml");
        context.start();
        System.in.read();
    }
}
