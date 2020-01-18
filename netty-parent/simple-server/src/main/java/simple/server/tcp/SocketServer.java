package simple.server.tcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import simple.handler.TcpChannelHandler;
import simple.server.BaseServer;

/**
 * Created  bhy on 2020/1/15
 * 扩展性示例  主要是将 channelHandler 模块拆分
 **/
public class SocketServer extends BaseServer {
    public SocketServer(int port) {
        super(port);
    }

    @Override
    public void run() {
        // 负责接收 请求的boss
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //负责处理 接收到的请求的worker
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new SocketDecoder(), new TcpChannelHandler());
                }
            });
            bootstrap.option(ChannelOption.SO_BACKLOG, 128);
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);

            //绑定端口

            future = bootstrap.bind(port).sync();

            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }

}
