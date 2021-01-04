package com.chinange.grow.juc;

public class TestMythread {
    public static void main(String[] args) throws InterruptedException {
        Mythread mythread = new Mythread("mythread-1");
        synchronized (mythread){
            System.out.println(Thread.currentThread().getName()+" run start method ");
            mythread.start();
            System.out.println(Thread.currentThread().getName()+" run wait method ");
            mythread.wait();
            System.out.println(Thread.currentThread().getName()+" thread wake up and die ");
        }
    }
}
