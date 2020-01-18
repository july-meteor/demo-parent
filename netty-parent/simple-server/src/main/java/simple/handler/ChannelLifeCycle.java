package simple.handler;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

import java.net.SocketAddress;

/**
 * Created  bhy on 2020/1/15
 *  为了明了的知道channel的运行的生命周期写的demo
 *
 **/
public class ChannelLifeCycle extends ChannelHandlerAdapter {
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.err.println("handlerAdded ，前置监听 ");
        super.handlerAdded(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.err.println("channelRegistered ，管道注册 ");
        super.channelRegistered(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.err.println("channelActive ，管道激活 ");
        super.channelActive(ctx);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.err.println("channelReadComplete ，管道读完 ");
        super.channelReadComplete(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);

        ctx.write(msg);
        ctx.flush();
        System.err.println("channelRead ，管道读");

    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.err.println("write, 写");
        super.write(ctx, msg, promise);
    }


    @Override
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        System.err.println("disconnect, 连接关闭");
        super.disconnect(ctx, promise);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.err.println("channelWritabilityChanged, 管道可写变更");
        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        System.err.println("close, 连接关闭");
        super.close(ctx, promise);
    }

    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
        System.err.println("flush, 缓存冲刷");
        super.flush(ctx);
    }

    @Override
    public boolean isSharable() {
        System.err.println("isSharable,是否共享");
        return super.isSharable();
    }

    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        System.err.println("read,读取");
        super.read(ctx);
    }

    @Override
    public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        System.err.println("bind, 管道绑定");
        super.bind(ctx, localAddress, promise);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.err.println("userEventTriggered, 用户事件触发");
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        System.err.println("connect, 连接");
        super.connect(ctx, remoteAddress, localAddress, promise);
    }

    /**
     * 频道无效
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.err.println("channelInactive ，管道销毁 ");
        super.channelInactive(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.err.println("handlerRemoved ，后置监听 ");
        super.handlerRemoved(ctx);
    }
}
