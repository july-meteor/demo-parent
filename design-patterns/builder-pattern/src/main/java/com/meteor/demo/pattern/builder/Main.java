package com.meteor.demo.pattern.builder;

/**
 * Created  meteor on 2020/11/5
 **/
public class Main {

    public static void main(String[] args) {

        Director director = new Director();
        Builder b1 = new ConcreteBuilderA();
        Builder b2 = new ConcreteBuilderB();

        director.build(b1);
        b1.getResult().show();
        director.build(b2);
        b2.getResult().show();
    }
}
