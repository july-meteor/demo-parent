package simple.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created  bhy on 2020/1/15
 **/
public class TcpChannelHandler extends ChannelHandlerAdapter {


    /**
     *  业务处理器
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);
//        ByteBuf b = (ByteBuf) msg;
//        while (b.isReadable()){
//            System.err.print((char) b.readByte());
//            System.err.flush();
//        }
//        ctx.write(msg);
//        ctx.flush();
        super.channelRead(ctx, msg);
    }

    /**
     *  建立连接会触发
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

            final ByteBuf time = ctx.alloc().buffer(4); // (2)
            time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

            final ChannelFuture f = ctx.writeAndFlush(time); // (3)

    }

    /**
     *  出现异常会被调用
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
