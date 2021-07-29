package com.wsy.firstdemo.callable;

import java.util.concurrent.Callable;

public class CallableTest implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 200;
    }
}
