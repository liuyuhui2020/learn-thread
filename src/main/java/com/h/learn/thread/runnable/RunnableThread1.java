package com.h.learn.thread.runnable;

/**
 * @ClassName Thread3
 * @Description TODO
 * @Author Admin
 * @Date 2020/7/12
 * @Version 1.0
 */
public class RunnableThread1 implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1.run");
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new RunnableThread1();
        Thread thread = new Thread(runnable);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main run");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
