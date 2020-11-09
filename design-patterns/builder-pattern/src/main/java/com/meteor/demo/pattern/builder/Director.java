package com.meteor.demo.pattern.builder;

/**
 * Created  meteor on 2020/11/5
 **/
public class Director {



    public void build(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
    }

}
