package com.littleball.io;

import java.io.*;
import java.util.Date;

public class TestPrintStream2 {
    public static void main(String[] args) {
        String str = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            PrintWriter pw = new PrintWriter(new FileWriter("E:\\PostgraduateStudy\\JavaSEStudy\\BasicStudy\\src\\com\\littleball\\io\\log.txt",true));
            while((str=br.readLine())!=null){
                if(str.equalsIgnoreCase("exit")){
                    break;
                }else{
                    pw.println("---------------------");
                    pw.println(str.toUpperCase());
                }
            }
            pw.println("===========================");
            pw.println("======"+new Date()+"=======");
            br.close();
            pw.close();
        }catch (IOException e){

        }

    }
}
