package com.littleball.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(6666);
        while(true){
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            System.out.println(dis.readUTF());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("Hello, "+s.getInetAddress()+" port#"+s.getPort()+". ByeBye!");
            dis.close();
            dos.flush();
            dos.close();
            s.close();
        }



    }
}
