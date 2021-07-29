package com.wsy.firstdemo.lock;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HashSetDemo {
    public static void main(String[] args) {

        //Set<String> set = new HashSet<>();

        //1、解决方法CopyOnWriteArraySet
//        Set<String> set = new CopyOnWriteArraySet<>();
//        for (int i = 1; i <10; i++) {
//            new Thread(()->{
//                set.add(UUID.randomUUID().toString().substring(0,8));
//                System.out.println(set);
//            },String.valueOf(i)).start();
//
//        }
//-----------------------------------------------------------------------
       // Map<String,String> map = new HashMap<>();
        //1、解决方案ConcurrentHashMap
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <10; i++) {
            String key = String.valueOf(i);
            new Thread(()->{
                map.put(key,UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();

        }
    }
}
