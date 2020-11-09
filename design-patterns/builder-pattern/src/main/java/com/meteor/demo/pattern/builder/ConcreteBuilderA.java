package com.meteor.demo.pattern.builder;

/**
 * Created  meteor on 2020/11/5
 **/
public class ConcreteBuilderA extends Builder {

    Product product = new Product();

    @Override
    public void buildPartA() {

        product.add("部件A");

    }

    @Override
    public void buildPartB() {
        product.add("部件B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
