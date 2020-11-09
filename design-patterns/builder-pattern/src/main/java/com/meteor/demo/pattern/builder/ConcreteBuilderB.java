package com.meteor.demo.pattern.builder;

/**
 * Created  meteor on 2020/11/5
 **/
public class ConcreteBuilderB extends Builder {

    Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("部件C");
    }

    @Override
    public void buildPartB() {
        product.add("部件d");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
