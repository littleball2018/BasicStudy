package com.littleball.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    public static List<Socket> sockets = new ArrayList<Socket>();

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);


//            List<Socket> list = new LinkedList<Socket>();
//            Socket s = ss.accept();
//            while(s!=null){
//                new Thread(new NewChatThread(s)).start();
//                s = ss.accept();
//            }

            while (true) {
                Socket s = ss.accept();
                sockets.add(s);
                new Thread(new NewChatThread(s)).start();

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
            //System.out.println("Server Error: " + ioe.getMessage());
        }
    }


}

class NewChatThread implements Runnable {
    private Socket socket;


    NewChatThread(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = null;
            PrintWriter pw = null;
            while (socket.isConnected()&&(str = br.readLine()) != null) {
                if (str.equalsIgnoreCase("byebye")) {
                    ChatServer.sockets.remove(socket);
                }
                System.out.println("Server: " + str);
                for (Socket s : ChatServer.sockets) {

                    pw = new PrintWriter(s.getOutputStream(), true);
                    pw.println(str);

                }
                if (str.equalsIgnoreCase("byebye")) {
                    br.close();
                    pw.close();
                    socket.close();
                }


//                PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
//                pw.println("send from server:" + str);
//                pw.flush();


            }
        } catch (SocketException se){
            System.out.println("it's gone.");//se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            //System.out.println("ReceiveMessage Error: "+ioe.getMessage());
        }
    }
}


