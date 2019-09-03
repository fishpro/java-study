package com.fishpro.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * java 动态打理
 * */
public class HelloProxy {
    public static void main(String [] args){

        HelloPrintImpl helloPrint1=new HelloPrintImpl();
        HelloPrint helloPrint=(HelloPrint)Proxy.newProxyInstance(helloPrint1.getClass().getClassLoader(),
                helloPrint1.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(helloPrint1,args);
                    }
                });
        helloPrint.printStr("fishpro","welcome to 今日头条");

    }
}
