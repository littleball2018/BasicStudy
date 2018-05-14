package com.littleball.thread;

public class TestYield {
    public static void main(String[] args) {
        YieldThread y1 = new YieldThread("y1");
        YieldThread y2 = new YieldThread("y2");
        y1.start();
        y2.start();

    }

}

class YieldThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ": " + i);
            if (i % 10 == 0) {
                yield();
            }
        }
    }

    public YieldThread(String name) {
        super(name);
    }
}