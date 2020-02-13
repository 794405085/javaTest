package cn.xj.testNio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

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
            //6.1监控客户端
            if (selector.select(2000)==0){
                System.out.println("Server:没有客户端搭理我，我就干点别的事");
                continue;
            }
            //6.2得到SelectionKey,判断通道里的事件
            Iterator<SelectionKey> keyIterators = selector.selectedKeys().iterator();
            while (keyIterators.hasNext()){
                SelectionKey key = keyIterators.next();

                if (key.isAcceptable()){//客户端连接事件
                    System.out.println("OP_ACCEPT");
                    SocketChannel accept = ssChannel.accept();//通过ServerSocketChannel获得channel
                    accept.configureBlocking(false);//非阻塞方式
                    accept.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));//将通道注册到selector
                }
                if (key.isReadable()){//读取客户端发送的消息
                    System.out.println("OP_READ");
                    SocketChannel channel = (SocketChannel)key.channel();//通过ServerSocketChannel获得channel
                    ByteBuffer buffer = (ByteBuffer)key.attachment();
                    channel.read(buffer);
                    System.out.println("客户端发过来的消息"+new String(buffer.array()));
                }


            }
            //手动从集合中移除当前key，防止重复处理
            keyIterators.remove();
        }

    }

}
