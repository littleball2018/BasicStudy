package com.littleball.socket;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;
import java.util.Scanner;

public class ChatClient {
    public static boolean flag = false;

    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 8888);
            flag = true;
            new Thread(new PostMessage(s)).start();
            new Thread(new ReceiveMessage(s)).start();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}

class ReceiveMessage implements Runnable {
    Socket s;

    ReceiveMessage(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            BufferedReader messageBr = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String str = null;
            while (s.isConnected() && (ChatClient.flag) && ((str = messageBr.readLine()) != null)) {
                System.out.println(str);
            }
            if (!ChatClient.flag) {
                messageBr.close();
                if (!s.isClosed()) {
                    s.close();
                }
            }
        }catch (SocketException se){
            //System.out.println("it's gone.");//se.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();

        }

    }
}

class PostMessage implements Runnable {
    Socket s;

    PostMessage(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            String timeStr = null, messageStr = "";
            Scanner keyStr = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            while (keyStr.hasNext()) {
                messageStr = keyStr.nextLine();
                timeStr = new Date().toString();
                pw.println("From: " + s.toString() + " " + s.getInetAddress() + " port#" + s.getPort() + " " + timeStr + " " + messageStr);
                if (messageStr.equalsIgnoreCase("byebye")) {
                    keyStr.close();
                    pw.close();
                    ChatClient.flag = false;
                    break;

//                    s.close();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();

        }


    }
}


