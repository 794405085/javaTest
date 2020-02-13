package cn.xj.testNio;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName TestNio
 * @Description: Nio编程
 * @Author 79440
 * @Date 2020/2/11
 * @Version V1.0
 **/
public class TestNio {
    /**
     * 将数据写入文件中
     * @throws Exception
     */
    @Test
    public void test1() throws  Exception{
        String str = "测试Nio编程";
        FileOutputStream fo = new FileOutputStream("test.txt");//获取输出流
        FileChannel foChannel = fo.getChannel();//获取通道
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);//设置缓冲区
        byteBuffer.put(str.getBytes());//通过通道将数据写入到缓冲区
        byteBuffer.flip();//看解释这个是内部重置，将读取指针放到缓冲头部，写到的位置变成limit 节省了时间
        foChannel.write(byteBuffer);
        fo.close();
    }

    /**
     * 从本地文件中读取数据
     * @throws Exception
     */
    @Test
    public  void test2() throws  Exception{
        File file = new File("test.txt");
        FileInputStream fis = new FileInputStream(file);//获取输入流
        FileChannel fu = fis.getChannel();//通过输入流获取通道
        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());//提供buffer缓冲区
        fu.read(buffer);//通过通道将数据读到缓冲区
        System.out.println(new String(buffer.array()));
        fis.close();
    }

    /**
     * 本地文件传输
     * @throws Exception
     */
    @Test
    public void test3() throws  Exception{
        FileInputStream fs = new FileInputStream("C:\\Users\\79440\\Desktop\\ceshi.avi");
        FileOutputStream fo = new FileOutputStream("d:\\ceshi.avi");
        FileChannel fsc = fs.getChannel();
        FileChannel foc = fo.getChannel();
        foc.transferFrom(fsc,0,fsc.size());
        fsc.close();
        foc.close();
    }
}


