package cn.xj.testNio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @ClassName NioClient
 * @Description:Nio网络编程客户端
 * @Author 79440
 * @Date 2020/2/13
 * @Version V1.0
 **/
public class NioClient {
    @Test
    public void nioClientTest() throws Exception{

        //1.得到一个网络通道1
        SocketChannel socketChannel = SocketChannel.open();
        //2.设置非阻塞方式
        socketChannel.configureBlocking(false);
        //3.提供服务端的地址和端口号
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);
        //4.连接到服务器
        if (!socketChannel.connect(address)){
            while (!socketChannel.finishConnect()){
                System.out.println("客户端没有连接到服务端 在干别的事");
            }
        }
        //5.得到一个缓冲区并写入数据
        String str = "hello NioServer";
        ByteBuffer bytes = ByteBuffer.wrap(str.getBytes());
        //6.发送数据
        socketChannel.write(bytes);
         System.in.read();
    }
}
