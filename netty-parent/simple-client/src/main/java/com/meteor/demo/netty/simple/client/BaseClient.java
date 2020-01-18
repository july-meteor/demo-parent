package com.meteor.demo.netty.simple.client;

import io.netty.channel.ChannelFuture;

/**
 * Created  bhy on 2020/1/15
 **/
public abstract class BaseClient {

    protected  String host;

    protected int port;

    protected ChannelFuture future;

    public  BaseClient(String host, int port){
        this.host =host;
        this.port =port;
    }

    public  abstract  void  run();
}
