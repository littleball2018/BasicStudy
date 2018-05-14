package com.littleball.io;

import java.io.*;

public class TestBufferedStream {
    public static void main(String[] args) {
        String str = "";
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            br = new BufferedReader(new FileReader("E:\\PostgraduateStudy\\JavaSEStudy\\BasicStudy\\src\\com\\littleball\\io\\test.txt"));
            bw = new BufferedWriter(new FileWriter("E:\\PostgraduateStudy\\JavaSEStudy\\BasicStudy\\src\\com\\littleball\\io\\test3.txt"));

            while((str=br.readLine())!=null){
                bw.write(str);
                bw.newLine();
                System.out.println(str);
            }
            br.close();
            bw.flush();
            bw.close();

        }catch (FileNotFoundException e1){
            e1.printStackTrace();
        }catch (IOException e2){
            e2.printStackTrace();
        }
    }
}
