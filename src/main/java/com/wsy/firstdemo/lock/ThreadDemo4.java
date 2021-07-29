package com.wsy.firstdemo.lock;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadDemo4 {
    public static void main(String[] args) {

       //不安全 List<String> list = new ArrayList<>();
       //1、Vector解决 List<String> list = new Vector<>();
        //2、Collections解决 List<String> list = Collections.synchronizedList(new ArrayList<>());
        //3、通过CopyOnWriteArrayList解决，写时复制技术（并发读，独立写），先复制，再合并。
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();

        }
    }
}
