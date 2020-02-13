package cn.xj.testSocket;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName myServer
 * @Description: TODO
 * @Author 79440
 * @Date 2020/2/12
 * @Version V1.0
 **/
public class MyServer {
    @Test
    public void myServerSocket() throws Exception{
        ServerSocket myserver = new ServerSocket(9999);
        Socket socket = myserver.accept();
        String str = "hello socket";
        byte[] bytes = new byte[1024];
        bytes = str.getBytes();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes);

        System.out.println("socket 连接成功");
        InputStream inputStream = socket.getInputStream();
        byte[] bytes1 = new byte[100];
        inputStream.read(bytes1);
        System.out.println(new String(bytes1));
    }

    @Test
    public void myFileServerSocket() throws Exception{
        ServerSocket myserver = new ServerSocket(9998);
        Socket socket = myserver.accept();
        File file = new File("test.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[100];

        OutputStream outputStream = socket.getOutputStream();

        System.out.println("socket 连接成功");
        int len = -1;
        while ((len = fis.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }
        fis.close();
        outputStream.close();
    }
}
