package com.chinange.grow.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多个线程轮流打印
 */
public class AlternationPrint {

    private Lock lock = new ReentrantLock();
    volatile int alternate = 0;
    volatile int printCount = 1;
    private Condition condition = lock.newCondition();
    public static void main(String[] args) throws InterruptedException {
        AlternationPrint alternationPrint = new AlternationPrint();
        PrintA pa = alternationPrint.new PrintA();
        PrintB pb = alternationPrint.new PrintB();
        PrintC pc = alternationPrint.new PrintC();

        pa.start();
        pb.start();
        pc.start();

        Thread.currentThread().sleep(2000);

        pa.interrupt();
        pb.interrupt();
        pc.interrupt();
    }
    class PrintA extends Thread {
        @Override
        public void run() {
            while (printCount < 5) {
                lock.lock();
                try {
                    while (alternate != 0) {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("-- A --"+printCount);
                    alternate = 1;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    class PrintB extends Thread {
        @Override
        public void run() {
            while (printCount < 5) {
                lock.lock();
                try {
                    while (alternate != 1) {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("-- B --"+printCount);
                    alternate = 2;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    class PrintC extends Thread {
        @Override
        public void run() {
            while (printCount < 6) {
                lock.lock();
                try {
                    while (alternate != 2) {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("-- C --"+printCount);
                    alternate = 0;
                    ++printCount;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
