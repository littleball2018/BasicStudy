package com.littleball.thread;

import java.util.Date;

public class TestInterrupt {
    public static void main(String[] args) {
        Runner1 r= new Runner1();
        Thread t = new Thread(r);
        t.start();
        try{
            Thread.sleep(10000);
            t.interrupt();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

class Runner1 implements Runnable{
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("=========" + new Date() + "==========");
                Thread.sleep(1000);
            }catch (InterruptedException e){
                return;
            }

        }
    }
}