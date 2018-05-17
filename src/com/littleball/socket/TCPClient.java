package com.littleball.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("127.0.0.1",6666);
        OutputStream out = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        int i=0;
        while(i<10){
            try{
                Thread.sleep(3000);
                dos.writeUTF("Hello Server!"+s.getInetAddress()+s.getPort());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            i++;
        }
        //System.out.println(dis.readUTF());
        dos.flush();
        dos.close();
        s.close();

    }
}
