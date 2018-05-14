package com.littleball.thread;

public class TestDeadLock implements Runnable{

    @Override
    public void run() {
        System.out.println("flag-"+flag);
        if(flag == 1){
            synchronized (o1){
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (o0){
                    System.out.println("flag1 success");
                }
            }

        }
        if (flag==0){
            synchronized (o0){
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("flag0 success");
                }
            }
        }
    }

    public static Object o0 = new Object(), o1 = new Object();
    public int flag;

    public static void main(String[] args) {
        TestDeadLock t0 = new TestDeadLock();
        TestDeadLock t1 = new TestDeadLock();
        t0.flag =0;
        t1.flag=1;
        Thread tt0 =new Thread(t0);
        Thread tt1= new Thread(t1);
        tt0.start();
        tt1.start();

    }
}
