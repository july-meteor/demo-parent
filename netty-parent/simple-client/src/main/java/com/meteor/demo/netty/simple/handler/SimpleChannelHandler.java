package com.meteor.demo.netty.simple.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * Created  bhy on 2020/1/15
 *
 *  改造
 **/
public class SimpleChannelHandler extends ChannelHandlerAdapter {
    //记录连接到销毁的 信息
    private ByteBuf byteBuf;

    /**
     * 管道创建前调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//        super.handlerAdded(ctx);
        byteBuf =ctx.alloc().buffer(4);
    }

    /**
     *  管道销毁后调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        byteBuf.release(); // (1)
        byteBuf = null;
    }

    /**
     *  read处理
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf m = (ByteBuf) msg;
        byteBuf.writeBytes(m); // (2)
        m.release();
        if (byteBuf.readableBytes() >= 4) { // (3)
            long currentTimeMillis = (byteBuf.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        }
    }

    /**
     *  异常处理
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
