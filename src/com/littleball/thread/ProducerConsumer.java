package com.littleball.thread;

public class ProducerConsumer {
    public static void main(String[] args) {
        Basket basket = new Basket();
        Producer p = new Producer(basket);
        Consumer c = new Consumer(basket);
        new Thread(p).start();
        new Thread(c).start();
        System.out.println("main left : "+ basket.index);

    }

}


class Mantou{
    int id;
    Mantou(int id){
        this.id =id;
    }
}

class Basket{
    Mantou[] arrMantou = new Mantou[10];
    int index=0;
    public synchronized void push(Mantou mt){
        while(index == 10){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();
        arrMantou[index] = mt;
        index++;
    }

    public synchronized Mantou pop(){
        while(index == 0){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        return arrMantou[index];
    }
}

class Producer implements Runnable{
    Basket basket;
    Producer(Basket basket){
        this.basket = basket;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            Mantou produceMt = new Mantou(i);
            basket.push(produceMt);
            System.out.println("Produce : "+i);
            System.out.println("Produce left : "+ basket.index);
            try{
                Thread.sleep((int)Math.random()*1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    Basket basket;
    Consumer(Basket basket){
        this.basket = basket;
    }
    @Override
    public void run() {
        int num;
        for(int i=0;i<20;i++){
            num = basket.pop().id;
            System.out.println("Consume : "+num);
            System.out.println("Consume left : "+ basket.index);
            try{
                Thread.sleep((int)Math.random()*1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}