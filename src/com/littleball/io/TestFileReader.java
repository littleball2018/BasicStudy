package com.littleball.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestFileReader {
    public static void main(String[] args) {
        int b=0;
        int num =0;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("E:\\PostgraduateStudy\\JavaSEStudy\\BasicStudy\\src\\com\\littleball\\io\\TestFileReader.java");
        } catch (FileNotFoundException e) {
            System.out.println("文件找不到，系统退出");
            System.out.println(-1);
        }
        try{
            while ((b=fileReader.read())!=-1){
                System.out.print((char)b);
                num++;

            }
            System.out.println("共读到"+num+"个字符");
        }catch (IOException e){
            System.out.println("文件读取失败，系统退出");
            System.exit(-1);
        }
    }


}
