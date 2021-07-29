package com.wsy.firstdemo.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 在主线程中需要执行比较耗时的操作时，但又不想阻塞主线程时，可以把这些
 * 作业交给 Future 对象在后台完成, 当主线程将来需要时，就可以通过 Future
 * 对象获得后台作业的计算结果或者执行状态
 *
 * 一般 FutureTask 多用于耗时的计算，主线程可以在完成自己的任务后，再去
 * 获取结果
 *
 * 仅在计算完成时才能检索结果；如果计算尚未完成，则阻塞 get 方法。一旦计
 * 算完成，就不能再重新开始或取消计算。get 方法而获取结果只有在计算完成
 * 时获取，否则会一直阻塞直到任务转入完成状态，然后会返回结果或者抛出异
 * 常。
 *
 * • 只计算一次
 */
public class CallableDemo {
    static class Thread1 implements Runnable{
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName()+"run方法");
        }
    }

    static class Thread2 implements Callable {

        @Override
        public Object call(){
            System.out.println(Thread.currentThread().getName()+"call方法");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"call方法restart");
            return null;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = new Thread1();

        Callable callable = new Thread2();

        FutureTask<Long> futureTask = new FutureTask<>(callable);

        new Thread(futureTask,"线程232332322").start();
        for (int i = 0; i < 10; i++) {
            Long result1 = futureTask.get();
            System.out.println(result1);

        }

        new Thread(runnable,"线程1212wq").start();
    }


}
