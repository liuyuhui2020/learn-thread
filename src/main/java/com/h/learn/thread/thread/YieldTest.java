package com.h.learn.thread.thread;

/**
 * @ClassName YeildTest
 * @Description 测试 yield:线程让出CPU资源
 * @Author Admin
 * @Date 2020/7/18
 * @Version 1.0
 */
public class YieldTest {

    public static void main(String[] args) {
        Thread5 thread5 = new Thread5();
        thread5.start();
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread5.yield();
        System.out.println("执行线程" + Thread.currentThread().getName());
    }
}

class Thread5 extends Thread {
    @Override
    public void run() {
        System.out.println("执行线程" + Thread.currentThread().getName());
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行线程结束" + Thread.currentThread().getName());
    }
}
