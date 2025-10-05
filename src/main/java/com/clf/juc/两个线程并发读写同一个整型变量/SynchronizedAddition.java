package com.clf.juc.两个线程并发读写同一个整型变量;

/**
 * ClassName: SynchronizedAddition
 * Package: com.clf.juc.两个线程并发读写同一个整型变量
 * Description:
 *
 * @Author clf
 * @Create 2025/10/5 22:00
 * @Version 1.0
 */
public class SynchronizedAddition {
    private static int num = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                synchronized (lock) {
                    num++;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                synchronized (lock) {
                    num++;
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("最终结果: " + num);
    }
}
