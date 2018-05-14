package com.littleball.thread;

public class TestSync2 implements Runnable{
    public int b = 1;

    public synchronized void f1(){
        b=1000;
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("f1 b = "+b);
    }

//    public void f2(){
//        System.out.println("f2 b = "+b);
//    }
    public  void f2(){
        try{
            Thread.sleep(2500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        b=2000;
        System.out.println(""+b);
    }

    @Override
    public void run() {
        f1();
    }

    public static void main(String[] args) {
        TestSync2 ts2= new TestSync2();
        Thread t = new Thread(ts2);
        t.start();
//        try{
//            Thread.sleep(1000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        ts2.f2();
        System.out.println("main b = "+ts2.b);
    }
}
