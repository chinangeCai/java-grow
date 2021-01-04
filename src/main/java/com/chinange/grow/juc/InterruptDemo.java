package com.chinange.grow.juc;

public class InterruptDemo  extends Thread{
    private boolean stopped = false;

    @Override
    public void run(){
        while(!stopped){
            System.out.println("   this thread is not stopped !   ");
        }
    }

    public void stopped(){
        /*Thread thread = Thread.currentThread();

        try {
            thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        this.stopped = true;
    }

    public static void main(String[] args) {


        InterruptDemo id = new InterruptDemo();
        id.start();
        id.stopped();
        id.interrupt();
    }
}
