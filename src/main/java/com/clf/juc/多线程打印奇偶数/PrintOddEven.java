package com.clf.juc.多线程打印奇偶数;

/**
 * ClassName: PrintOddEven
 * Package: com.clf.juc.多线程打印奇偶数
 * Description:
 *
 * @Author clf
 * @Create 2025/10/5 19:19
 * @Version 1.0
 */
public class PrintOddEven {
    private static final Object LOCK = new Object();
    private static int count = 1;
    private static final int MAX = 100;

    public static void main(String[] args) {
        Runnable oddRunnable = () -> {
            while (count<=MAX){
                synchronized (LOCK){
                    if(count%2==1){
                        System.out.println(Thread.currentThread().getName()+"打印:"+count);
                        count++;
                        LOCK.notify();
                    }else{
                        try {
                            LOCK.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Runnable evenRunnable = () -> {
            while (count<=MAX){
                synchronized (LOCK){
                    if(count%2==0){
                        System.out.println(Thread.currentThread().getName()+"打印:"+count);
                        count++;
                        LOCK.notify();
                    }else{
                        try {
                            LOCK.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        new Thread(oddRunnable,"线程1").start();
        new Thread(evenRunnable,"线程2").start();

    }
}
