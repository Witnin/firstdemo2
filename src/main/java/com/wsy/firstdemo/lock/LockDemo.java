package com.wsy.firstdemo.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        //Lock可重入锁，有上锁就得有解锁，不然别的线程会出现问题
        Lock lock = new ReentrantLock();
        new Thread(()->{
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"外层");
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+"中层");
                    try {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName()+"内层");
                    }finally {
                        lock.unlock();
                    }
                }finally {
                    lock.unlock();
                }

            }finally {
                lock.unlock();
            }


        },"T2").start();
    }
}
