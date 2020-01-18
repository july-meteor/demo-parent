package simple.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.ByteBuffer;

/**
 * Created  bhy on 2020/1/15
 **/
public class SimpleChannelHandler extends SimpleChannelInboundHandler<ByteBuffer> {
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

    /**
     * 频道无效
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

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, ByteBuffer byteBuffer) throws Exception {

    }
}
