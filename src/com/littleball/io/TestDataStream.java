package com.littleball.io;

import java.io.*;

public class TestDataStream {
    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        char c;byte b= 0;
        try{
            dos.writeBoolean(true);
            dos.writeDouble(Math.random());
//            dos.writeBytes("123");
            dos.writeChars("123456");
            dos.flush();


            ByteArrayInputStream bais =new ByteArrayInputStream(baos.toByteArray());
            DataInputStream dis = new DataInputStream(bais);
            System.out.println(dis.readBoolean());
            System.out.println(dis.readDouble());
//            while((b =dis.readByte())!=-1){
//                System.out.print(b);
//            }
            dis.close();
            dos.close();


//            while(!String.valueOf(c=dis.readChar()).equals("")){
//                System.out.println(c);
//            }
//            dis.close();
//            dos.close();

        }catch(EOFException e2){
            e2.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
