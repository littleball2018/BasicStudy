package com.littleball.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TestPrintStream {
    public static void main(String[] args) {
        FileOutputStream out = null;
        PrintStream ps = null;
        try{
            out = new FileOutputStream("E:\\PostgraduateStudy\\JavaSEStudy\\BasicStudy\\src\\com\\littleball\\io\\test4.txt");
            ps = new PrintStream(out);
            if(ps!=null){
                System.setOut(ps);
            }
            for(int i=0;i<60000;i++){
                System.out.print((char)i);
                if((i%100)==0){
                    System.out.println();
                }
            }


        }catch (FileNotFoundException e){
            e.printStackTrace();

        }
    }
}
