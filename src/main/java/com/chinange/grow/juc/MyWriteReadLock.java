package com.chinange.grow.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *  读写锁
 */
public class MyWriteReadLock {
    public static void main(String[] args) {
        ReentrantReadWriteLock wrlock = new ReentrantReadWriteLock();

        Lock readLock = wrlock.readLock();
        Lock writeLock = wrlock.writeLock();




    }
}
