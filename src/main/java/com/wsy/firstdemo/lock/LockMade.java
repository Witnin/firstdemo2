package com.wsy.firstdemo.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MakePrint{
    private int flag = 1;

    private Lock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();

    private Condition conditionB = lock.newCondition();

    private Condition conditionC = lock.newCondition();

    public void printA(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag!=1){
                conditionA.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName()+"::"+i+"轮数"+loop);
            }
            flag = 2;
            conditionB.signal();
        }finally {
            lock.unlock();
        }
    }

    public void printB(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag!=2){
                conditionB.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName()+"::"+i+"轮数"+loop);
            }
            flag = 3;
            conditionC.signal();
        }finally {
            lock.unlock();
        }
    }

    public void printC(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag!=3){
                conditionC.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName()+"::"+i+"轮数"+loop);
            }
            flag = 1;
            conditionA.signal();
        }finally {
            lock.unlock();
        }
    }


}


public class LockMade {
    public static void main(String[] args) {

        MakePrint makePrint = new MakePrint();
        new Thread(()->{
            for (int i = 1; i <= 10 ; i++) {
                try {
                    makePrint.printA(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 1; i <= 10 ; i++) {
                try {
                    makePrint.printB(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();

        new Thread(()->{
            for (int i = 1; i <= 10 ; i++) {
                try {
                    makePrint.printC(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();
    }
}
