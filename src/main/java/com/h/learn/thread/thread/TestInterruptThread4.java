package com.h.learn.thread.thread;

/**
 * @ClassName Thread4
 * @Description 测试线程停止方法interrupt
 * @Author Admin
 * @Date 2020/7/12
 * @Version 1.0
 */
public class TestInterruptThread4 extends Thread {
    public static void main(String[] args) {
        Thread thread = new TestInterruptThread4();
        thread.start();
        thread.interrupt();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
        //如果中断的线程有sleep方法，会抛出InterruptedException
        //如果没有sleep方法，则不会抛异常
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
