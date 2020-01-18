package simple;


import simple.server.tcp.TcpServer;

/**
 * Created  bhy on 2020/1/15
 **/
public class NettyServerBootstrap {

    public static void main(String[] args) {
        new TcpServer(8080).run();
    }
}
