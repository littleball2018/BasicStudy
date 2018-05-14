package com.littleball.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestOutputStream {
    public static void main(String[] args) {
        int b= 0;
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("E:\\PostgraduateStudy\\JavaSEStudy\\BasicStudy\\src\\com\\littleball\\io\\test.txt");
            out = new FileOutputStream("E:\\PostgraduateStudy\\JavaSEStudy\\BasicStudy\\src\\com\\littleball\\io\\test2.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            while ((b=in.read())!=-1){
                out.write(b);

            }
            in.close();
            out.flush();
            out.close();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
