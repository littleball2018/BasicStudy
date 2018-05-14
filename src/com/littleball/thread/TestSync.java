package com.littleball.thread;

public class TestSync implements Runnable {
    Timer timer = new Timer();

    @Override
    public void run() {
        String str = Thread.currentThread().getName();
        timer.func(str);
    }

    public static void main(String[] args) {
        TestSync testSync = new TestSync();
        Thread t2 = new Thread(testSync, "t1");
        Thread t1 = new Thread(testSync, "t2");
        t1.start();
        t2.start();
        System.out.println("main");

    }
}

class Timer {
    public static int num = 0;

    public synchronized void func(String name) {
        num++;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello, " + name + " U are " + num + " visitor");
    }
}