package cn.xj.testSocket;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName Myclient
 * @Description: TODO
 * @Author 79440
 * @Date 2020/2/12
 * @Version V1.0
 **/
public class Myclient {
    @Test
    public void myClient() throws Exception{
        Socket socket = new Socket("127.0.0.1", 9999);
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[100];
        inputStream.read(bytes);
        System.out.println(new String(bytes));

        OutputStream outputStream = socket.getOutputStream();
        String str = "我已经收到了 谢谢";
        outputStream.write(str.getBytes());

    }

    @Test
    public void myFileClient() throws Exception{
        Socket socket = new Socket("127.0.0.1", 9998);
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[100];
        FileOutputStream fos = new FileOutputStream("d:\\test.txt");
        int len = -1;
        while ((len = inputStream.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        fos.close();

        inputStream.close();

    }
}
