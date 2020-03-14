package com.meteor.demo.pattern.proxy.sample;

/**
 * Created  bhy on 2020/3/14
 **/
public class ITestDao implements   TestDao {

    @Override
    public void say(String test) {
        System.err.println(test);
    }
}
