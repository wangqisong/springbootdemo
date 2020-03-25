package com.example.demo.test;


import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author: wangqisong
 * @date: 2020/3/23
 * @Description:
 */
public class SocketClientTest {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            Socket client = new Socket("127.0.0.1", 7777);
            OutputStreamWriter osw = new OutputStreamWriter(client.getOutputStream());
            osw.write(""+i+i+i+i+i+i+i+i);
            osw.flush();
            osw.close();
        }

    }
}
