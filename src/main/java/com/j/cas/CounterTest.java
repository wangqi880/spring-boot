package com.j.cas;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0 created by xxxx on 2018/9/7 10:15
 */
public class CounterTest  {

    private static AtomicInteger ai = new AtomicInteger();
    private static int i = 0;

    private static void safeAdd() {
        for (; ; ) {
            int j = ai.get();
            boolean flag = ai.compareAndSet(j, j + 1);
            if (flag) {
                break;
            }
        }
    }
    private static void add() {
        i = i + 1;
    }
    public static void main(String[] args) {
        /*ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<1000;i++){
            executorService.execute(()->{
                add();
                safeAdd();
            });
        }
        //等待20秒 让子线程执行完
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("我是不安全的:"+i);
        System.out.println("我是安全的"+ai.get());
*/
        List<String> list=null;
        for (String s : list) {

        }

    }
}
