package com.wsy.firstdemo.sync;

class Share{
    private int number = 0;

    public synchronized void incr() throws InterruptedException {

        while (number !=0){
          this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"::"+number);
        this.notifyAll();
    }

    public synchronized void decr() throws InterruptedException {

        while (number !=1){
            this.wait(); //wait在哪里睡就在哪里醒,不能用if,需要用while
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"::"+number);
        this.notifyAll();
    }
}



public class MainThreadDemo {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }

        }

    }

    public static void bubbleSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }

        }

    }

    public static void main(String[] args) {

        int[] arr = {12, 23, 11, 88,221,12,11,3};
        bubbleSort2(arr);
        for (int i = 0; i < arr.length-1; i++) {
            int temp = i+1;
            if(arr[i+1] == arr[i]){
                temp = i;
            }

            System.out.print("\t" +"名次:"+temp+ "，值:"+arr[i]);
        }
//        Share share = new Share();
//        new Thread(()->{
//            for(int i =1;i<=10;i++){
//                try {
//                    share.incr();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"AA").start();
//
//        new Thread(()->{
//            for(int i =1;i<=10;i++){
//                try {
//                    share.decr();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"BB").start();
//
//
//        new Thread(()->{
//            for(int i =1;i<=10;i++){
//                try {
//                    share.incr();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"CC").start();
//
//        new Thread(()->{
//            for(int i =1;i<=10;i++){
//                try {
//                    share.decr();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"DD").start();
//




    }
}
