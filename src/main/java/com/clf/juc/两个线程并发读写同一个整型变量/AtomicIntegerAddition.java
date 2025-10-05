package com.clf.juc.两个线程并发读写同一个整型变量;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName: AtomicIntegerAddition
 * Package: com.clf.juc.两个线程并发读写同一个整型变量
 * Description:
 *
 * @Author clf
 * @Create 2025/10/5 21:56
 * @Version 1.0
 */
public class AtomicIntegerAddition {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                atomicInteger.incrementAndGet();
            }
        }, "线程1");

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                atomicInteger.incrementAndGet();
            }
        }, "线程2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(Thread.currentThread().getName()+"\t"+"最终结果为："+atomicInteger.get());
    }
}
