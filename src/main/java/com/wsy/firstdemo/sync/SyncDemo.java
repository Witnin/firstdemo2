package com.wsy.firstdemo.sync;

public class SyncDemo {

    public synchronized void add(){
        add();
    }

    public static void main(String[] args) {

        new SyncDemo().add();//栈溢出

        //synchronized(隐式)可重入锁
//        Object o = new Object();
//        new Thread(()->{
//            synchronized (o){
//                System.out.println(Thread.currentThread().getName()+"外层");
//                synchronized (o){
//                    System.out.println(Thread.currentThread().getName()+"中层");
//                    synchronized (o){
//                        System.out.println(Thread.currentThread().getName()+"内层");
//                    }
//                }
//            }
//        },"T1").start();
    }
}
