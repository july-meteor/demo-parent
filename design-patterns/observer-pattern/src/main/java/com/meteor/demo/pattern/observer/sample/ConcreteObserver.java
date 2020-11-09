package com.meteor.demo.pattern.observer.sample;

/**
 * Created  meteor on 2020/11/9
 **/
public class ConcreteObserver implements Observer {

    /**
     *
     */
    String name;
    /**
     * 观察者状态
     */
    String state;

    ConcreteSubject subject;

    public ConcreteObserver(String name, ConcreteSubject subject) {
        this.name = name;
        this.subject = subject;
    }


    @Override
    public void update() {
        this.state = subject.getSubjectState();
        System.err.printf("观察者%s的新状态是%s\n", name, state);
    }
}
