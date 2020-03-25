package com.example.demo.test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: wangqisong
 * @date: 2020/3/23
 * @Description:
 */
public class SocketServerTest {
    private static ServerSocket serverSocket;

    public SocketServerTest() {
        synchronized (this) {
            try {
                if (serverSocket == null) {
                    serverSocket = new ServerSocket(7777);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SocketServerTest socketServerTest = new SocketServerTest();
        System.out.println("====服务端启动成功====");
        ExecutorService executorService = Executors.newCachedThreadPool();
        Socket client;
        int count =1;
        while (true) {
            client = serverSocket.accept();
            System.out.println("====客户端:"+count+"连接成功====");
            count++;
            executorService.execute(socketServerTest.new WorkThread(client));
        }

    }

    private  class WorkThread implements Runnable{
        private Socket client;
        public WorkThread(Socket client){
            this.client = client;
        }
        @Override
        public void run() {
            try {
                StringBuffer sb = new StringBuffer();
                InputStreamReader isr = new InputStreamReader(client.getInputStream());
                char[] chars = new char[1024];
                int read;
                while (!((read = isr.read(chars, 0, 1024)) < 1024)) {
                    String str = new String(chars);
                    sb.append(str);
                    chars = new char[1024];
                }
                if (read<1024){
                    String str = new String(chars);
                    sb.append(str);
                }
                System.out.println("服务器收到"+sb.toString());
                isr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
