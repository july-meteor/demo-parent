package com.meteor.demo.pattern.observer.test.sample;

import com.meteor.demo.pattern.observer.sample.ConcreteObserver;
import com.meteor.demo.pattern.observer.sample.ConcreteSubject;

/**
 * Created  meteor on 2020/11/9
 **/
public class Main {

    public static void main(String[] args) {

        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver("X", subject));
        subject.attach(new ConcreteObserver("Y", subject));
        subject.attach(new ConcreteObserver("Z", subject));
        subject.setSubjectState("测试");
        subject.call();


    }

}
