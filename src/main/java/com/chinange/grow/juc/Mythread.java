package com.chinange.grow.juc;

public class Mythread extends Thread {

    public Mythread(String name){
        super(name);
    }
    public void run(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+" run notify method ");
            for (int i = 0; i < 5; i++) {
                System.out.println(".");
            }
            notify();
        }
    }
}
