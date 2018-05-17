package com.littleball.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ChatServer{
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            String shareStr = "";

            DoAllChatThread allChat = new DoAllChatThread();
//            List<Socket> list = new LinkedList<Socket>();
//            Socket s = ss.accept();
//            while(s!=null){
//                new Thread(new NewChatThread(s)).start();
//                s = ss.accept();
//            }
            while (true) {
                Socket s = ss.accept();
                allChat.add(s);
                new Thread(new NewChatThread(s)).start();

            }

        } catch (IOException ioe) {
            //System.out.println("Server Error: " + ioe.getMessage());
        }
    }
}

class NewChatThread implements Runnable {
    private Socket socket;
    private int flag;
    private String shareStr="";

    NewChatThread(Socket socket) {
        this.socket = socket;
        this.flag = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                flag = 1;
                String str = br.readLine();
                shareStr = str;
                System.out.println(str);
//                PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
//                pw.println("send from server:" + str);
//                pw.flush();
                flag = 0;

            } catch (IOException ioe) {
                //System.out.println("ReceiveMessage Error: "+ioe.getMessage());
            }
        }
    }
}

class DoAllChatThread implements Runnable {
    private List<Socket> socketList = new LinkedList<Socket>();



    public void add(Socket socket) {
        socketList.add(socket);
    }

    @Override
    public void run() {

    }
}
