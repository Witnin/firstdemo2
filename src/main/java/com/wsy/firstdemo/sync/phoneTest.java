package com.wsy.firstdemo.sync;


import java.util.concurrent.TimeUnit;

class Phone{
    public static synchronized void sendSms() throws Exception{
        TimeUnit.SECONDS.sleep(4);
        System.out.println(Thread.currentThread().getName()+":-----SendSms----");
    }

    public synchronized void sendEmail() throws Exception{
        System.out.println(Thread.currentThread().getName()+":-----sendEmail----");
    }

    public void getHello(){

        System.out.println("------getHello----");

    }
}

public class phoneTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();


        new Thread(()->{
            try {
                phone.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"AA").start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            try {
                //phone.sendEmail();
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"BB").start();
    }


}
