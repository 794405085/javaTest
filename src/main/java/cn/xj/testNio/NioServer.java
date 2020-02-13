package cn.xj.testNio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @ClassName NioServer
 * @Description: Nio网络编程
 * @Author 79440
 * @Date 2020/2/13
 * @Version V1.0
 **/
public class NioServer {

    @Test
    public void noiServerTest() throws Exception{
        //1.获取ServerSocketChannle对象
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //2.得到Selector对象
        Selector selector = Selector.open();
        //3.绑定一个端口号
        ssChannel.bind(new InetSocketAddress(9999));
        //4.设置非阻塞方式
        ssChannel.configureBlocking(false);
        //5.把ServerSocketChannle注册到Select中
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6.doWork
        while (true){

        }

    }

}
