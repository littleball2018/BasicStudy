package com.littleball.thread;

public class TestThread1 {
    public static void main(String[] args) {
        MyRunner myr = new MyRunner();
        Thread t = new Thread(myr);
        t.start();

        for(int i=0;i<100;i++){
            System.out.println("MainThread: "+i);
        }
    }
}

class MyRunner implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("MyRunner: "+i);
        }
    }
}
