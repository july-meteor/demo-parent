package com.meteor.demo.pattern.builder;

/**
 * Created  meteor on 2020/11/5
 **/
public abstract class Builder {
    /**
     *  创建部件1
     */
    public abstract void buildPartA();

    /**
     *  创建部件2
     */
    public abstract void buildPartB();

    /**
     *  获取成品
     */
    public abstract Product getResult();


}
