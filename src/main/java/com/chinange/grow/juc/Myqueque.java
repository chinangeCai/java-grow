package com.chinange.grow.juc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Myqueque<T> {

    //private int index; //插入数据下标

    private int capacity = 800; // 容量

    private Lock lock;

    private Condition addcondition;

    private Condition rmcondition;

    public Myqueque(){
        this.lock = new ReentrantLock();
        this.addcondition = lock.newCondition();
        this.rmcondition = lock.newCondition();
    }

    public Myqueque(int capacity){
        this.capacity = capacity;
        this.lock = new ReentrantLock();
        this.addcondition = lock.newCondition();
        this.rmcondition = lock.newCondition();
    }

    private ConcurrentHashMap<Integer,String> cache  = new ConcurrentHashMap<>(2<<11);

    public boolean add(int index, String hash){
        lock.lock();
        boolean success = true;
        try{

        if(cache.size() == capacity){
            addcondition.await();
        }
            cache.put(index,hash);
            rmcondition.signalAll();//唤醒消费线程
        } catch (InterruptedException e) {
            e.printStackTrace();
            success = false;
        } finally {
            lock.unlock();
        }
        return success;
    }

    public String remove(int index){
        lock.lock();
        String value = null;
        try{
            if(cache.isEmpty()){
                rmcondition.await();
            }
            value = cache.remove(index);
            addcondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return value;
    }
}
