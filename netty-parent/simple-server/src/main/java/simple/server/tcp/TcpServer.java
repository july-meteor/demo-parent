package simple.server.tcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import simple.handler.ChannelLifeCycle;
import simple.server.BaseServer;

/**
 * Created  bhy on 2020/1/15
 *   基本的实现方式示例
 **/
public class TcpServer  extends BaseServer {
    public TcpServer(int port) {
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
            bootstrap.group(bossGroup,workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
//                    socketChannel.pipeline().addLast(new TcpChannelHandler());
                    socketChannel.pipeline().addLast(new ChannelLifeCycle());
                }
            });
            bootstrap.option(ChannelOption.SO_BACKLOG,128);
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);

            //绑定端口

            future = bootstrap.bind(port).sync();

            future.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

}
