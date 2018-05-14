package com.littleball.thread;

public class TestPriority {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.setPriority(Thread.NORM_PRIORITY+3);
        t1.start();
        t2.start();
    }

}

class T1 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<500;i++){
            System.out.println("T1: "+i);
        }
    }
}

class T2 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<500;i++){
            System.out.println("======T2: "+i);
        }
    }
}
