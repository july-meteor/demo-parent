package com.meteor.demo.pattern.proxy.sample;

/**
 * Created  bhy on 2020/3/14
 **/
public class TestServiceImpl implements TestService {

    private  TestDao dao;

    public  TestServiceImpl(TestDao dao){
        this.dao =dao;
    }
    @Override
    public void testSay(String text) {
        dao.say(text);
    }
}
