package com.littleball.socket;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 8888);
            String timeStr = null, messageStr = "";
            BufferedReader keyBr = null;
            PrintWriter pw = null;
            BufferedReader messageBr = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while (!messageStr.equalsIgnoreCase("byebye")) {
                keyBr = new BufferedReader(new InputStreamReader(System.in));
                timeStr = new Date().toString();
                messageStr = keyBr.readLine();
                pw = new PrintWriter(s.getOutputStream(), true);
                pw.println("From: "+s.toString()+" "+s.getInetAddress()+ " port#"+s.getPort()+" "+timeStr + " " + messageStr);
                pw.flush();
                //System.out.println(messageBr.readLine());
            }
            keyBr.close();
            pw.close();
            messageBr.close();
            s.close();

        } catch (IOException ioe) {
            System.out.println("Client Error: " + ioe.getMessage());
        }
    }
}
