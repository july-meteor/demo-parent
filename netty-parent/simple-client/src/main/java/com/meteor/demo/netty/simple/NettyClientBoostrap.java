package com.meteor.demo.netty.simple;

import com.meteor.demo.netty.simple.client.tcp.TcpClient;

/**
 * Created  bhy on 2020/1/15
 **/
public class NettyClientBoostrap {

    public static void main(String[] args) {
        new TcpClient("localhost",8080).run();
    }
}
