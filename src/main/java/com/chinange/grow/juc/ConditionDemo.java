package com.chinange.grow.juc;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    private final int queueSize = 10;
    private final PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        ConditionDemo cd = new ConditionDemo();
        Producer producer = cd.new Producer();
        Consumer consumer = cd.new Consumer();
        producer.start();
        consumer.start();
        Thread.sleep(0);
        producer.interrupt();
        consumer.interrupt();
    }

    class Consumer extends Thread{
        @Override
        public void run() {
            consume();
        }
        volatile boolean flag = true;
        private void consume(){
            while(flag){
                lock.lock();
                try{
                    while(queue.isEmpty()){
                        try{
                            System.out.println("queue is empty");
                            notEmpty.await();
                        }catch (InterruptedException e){
                            flag = false;
                        }
                    }
                    queue.poll(); // remove a e;
                    notFull.signal();
                    System.out.println("queue left:"+queue.size());
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    class Producer extends Thread {

        @Override
        public void run() {
            produce();
        }
        volatile boolean flag = true;
        private void produce(){
            while(flag){
                lock.lock();
                try{
                    while(queue.size() == queueSize){
                        try{
                            System.out.println("queue is full");
                            notFull.await();
                        }catch(InterruptedException e){
                            flag = false;
                        }
                    }
                    queue.offer(1); // insert a e;
                    notEmpty.signal();
                    System.out.println("queue have: "+(queueSize - queue.size()));
                }finally {
                    lock.unlock();
                }
            }
        }
    }

}


