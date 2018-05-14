package com.littleball.thread;

public class TestJoin {
    public static void main(String[] args) {
        JoinThread jt = new JoinThread();
        Thread t = new Thread(jt,"name-join");
        t.start();
        try{
            t.join();
            for(int i=0;i<20;i++){
                System.out.println("MainThread: "+i);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

class JoinThread implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("JoinThread: "+i);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
                return;
            }
        }
    }
}