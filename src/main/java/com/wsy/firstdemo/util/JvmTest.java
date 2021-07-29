package com.wsy.firstdemo.util;

public class JvmTest {
    public static void main(String[] args) {
        int i = 2+3;

        String hello = null;
        try {
            Thread.sleep(6000);

            hello = "hello";

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(hello);
    }
}
