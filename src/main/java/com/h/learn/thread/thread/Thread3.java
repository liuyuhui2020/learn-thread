package com.h.learn.thread.thread;

/**
 * @ClassName Thread3
 * @Description 测试线程的currentThread getId isAlive
 * @Author Admin
 * @Date 2020/7/12
 * @Version 1.0
 */
public class Thread3 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + "是否存活：" + this.isAlive());
    }

    public Thread3() {
        System.out.println("构造方法的线程ID是：" + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        System.out.println("main方法的线程ID是：" + Thread.currentThread().getId());
        Thread thread = new Thread3();
        thread.start();
        System.out.println("main方法的线程是否存活：" + Thread.currentThread().isAlive());
        thread.isAlive();
    }
}
