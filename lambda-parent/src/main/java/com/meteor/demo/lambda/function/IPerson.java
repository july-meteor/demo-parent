package com.meteor.demo.lambda.function;

/**
 * Created  meteor on 2020/4/21
 **/
@FunctionalInterface
public interface IPerson {
    String say(String input);
    //void stand(); 只能有一个抽象方法，不然编译无法默认识别调用

    static void run(String xx){
        System.err.println("IPerson run : " + xx);
    }

    static void walk(){
        System.err.println("IPerson walk");
    }

    default void eat(int a, int b){
        System.err.println("IPerson eat : " + a + " - " + b);
    }
}
