package com.littleball.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {
    public static void main(String[] args) {
        int b;
        int num=0;
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream("E:\\PostgraduateStudy\\JavaSEStudy\\BasicStudy\\src\\com\\littleball\\io\\TestFileInputStream.java");

        }catch (FileNotFoundException e){
            System.out.println("文件找不到，系统退出。");
            System.exit(-1);
        }

        try{
            while((b=fileInputStream.read())!=-1){
               num++;
               System.out.print((char)b);
            }
            fileInputStream.close();
            System.out.println("共读到"+num+"个字节。");
        }catch (IOException e){
            System.out.println("文件读取失败，系统退出。");
            System.exit(-1);
        }


    }
}
