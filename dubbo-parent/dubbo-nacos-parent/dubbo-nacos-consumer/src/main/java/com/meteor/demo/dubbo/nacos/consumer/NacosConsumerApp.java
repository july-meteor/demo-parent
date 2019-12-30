package com.meteor.demo.dubbo.nacos.consumer;

import com.meteor.demo.dubbo.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by Meteor on 2019/12/29
 *  通过nacos 注册的服务进行消费
 */
public class NacosConsumerApp {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
        context.start();
        DemoService demoService = context.getBean("DemoService", DemoService.class);
        String result = demoService.sayHello("world");
        System.out.println("result: " + result);
    }

}
