package com.meteor.demo.netty.simple.client.tcp;

import com.meteor.demo.netty.simple.client.BaseClient;
import com.meteor.demo.netty.simple.handler.SimpleChannelHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created  bhy on 2020/1/15
 * <p>
 * 除了只有一个处理的group以外基本跟 server差不多
 **/
public class TcpClient extends BaseClient {
    public TcpClient(String host, int port) {
        super(host, port);
    }

    @Override
    public void run() {
        // client 只有一个 worker负责全部工作
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new SimpleChannelHandler());
                }
            });
            future = bootstrap.connect(host, port).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {

        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
