package com.wsy.firstdemo.lock;

import java.util.concurrent.locks.ReentrantLock;

class LTicket{
    private int number = 30;

    private final ReentrantLock lock = new ReentrantLock(true);

    public void sale(){
        lock.lock();
        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName()+":当前票数"+(number--)+"，卖出1张，剩余:"+number);
            }
        }finally {
            lock.unlock();
        }


    }
}


public class LockSaleTicket {
    public static void main(String[] args) {
        LTicket lTicket = new LTicket();

        new Thread(()->{
            for (int i = 0; i <40 ; i++) {
                lTicket.sale();
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i <40 ; i++) {
                lTicket.sale();
            }
        },"BB").start();

        new Thread(()->{
            for (int i = 0; i <40 ; i++) {
                lTicket.sale();
            }
        },"CC").start();
    }
}
