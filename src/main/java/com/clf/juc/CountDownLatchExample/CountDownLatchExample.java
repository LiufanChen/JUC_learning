package com.clf.juc.CountDownLatchExample;

import java.util.concurrent.CountDownLatch;

/**
 * ClassName: CountDownLatchExample
 * Package: com.clf.juc.CountDownLatchExample
 * Description:
 *
 * @Author clf
 * @Create 2025/10/5 19:33
 * @Version 1.0
 */
public class CountDownLatchExample {
    private static final int MAX_COUNT = 4;

    public static void main(String[] args) {
        //创建CountDownLatch对象
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for(int i = 1; i <= 4; i++){
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+ " is working.");
                    Thread.sleep(( long)(Math.random()*1000));
                    System.out.println(Thread.currentThread().getName()+ " is done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            },"[线程]-"+i).start();
        }

        new Thread(() -> {
            try {
                System.out.println("等待所有线程执行完毕...");
                countDownLatch.await();
                System.out.println("所有线程执行完毕...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"[线程]-"+5).start();



    }
}
