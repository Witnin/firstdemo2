package com.wsy.firstdemo.util;

import com.fasterxml.jackson.core.JsonToken;
import org.apache.tomcat.util.net.jsse.JSSEUtil;

import java.net.URL;
import java.security.Provider;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);

        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        ClassLoader classloader2 = String.class.getClassLoader();
        System.out.println(classloader2);

        System.out.println("************启动类加载器************");
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(URL element : urls){
            System.out.println(element.toExternalForm());
        }

        ClassLoader classLoader3 = Provider.class.getClassLoader();
        System.out.println(classLoader3);
    }
}
