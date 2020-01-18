package simple.server;

import io.netty.channel.ChannelFuture;

/**
 * Created  bhy on 2020/1/15
 **/


public abstract class BaseServer {

    protected int port;

    protected ChannelFuture future;


    public BaseServer(int port){

        this.port =port;

    }

    public   abstract  void  run();
}
