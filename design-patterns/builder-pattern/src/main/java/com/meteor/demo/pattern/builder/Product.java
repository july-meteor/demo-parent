package com.meteor.demo.pattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  meteor on 2020/11/5
 **/
public class Product {

    List<String> parts = new ArrayList<>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        parts.stream().forEach(System.out::println);
    }
}
