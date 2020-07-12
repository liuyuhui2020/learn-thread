package com.h.learn.thread.thread;

/**
 * @ClassName Thread3
 * @Description TODO
 * @Author Admin
 * @Date 2020/7/12
 * @Version 1.0
 */
public class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Thread2 run");
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Thread thread2 = new Thread2();
        thread2.start();
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("main run");
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
