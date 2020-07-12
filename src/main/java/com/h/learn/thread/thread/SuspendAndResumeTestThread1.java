package com.h.learn.thread.thread;

/**
 * @ClassName SuspendAndResumeTestThread
 * @Description TODO
 * @Author Admin
 * @Date 2020/7/12
 * @Version 1.0
 */
public class SuspendAndResumeTestThread1 extends Thread {
    @Override
    synchronized public void run() {
        while (true) {
            if ("A".equals(this.getName())) {
                System.out.println("A");
            } else {
                System.out.println("!A");
            }
        }


    }

    public static void main(String[] args) {
        SuspendAndResumeTestThread1 threadA = new SuspendAndResumeTestThread1();
        SuspendAndResumeTestThread1 threadB = new SuspendAndResumeTestThread1();
        threadA.setName("A");
        threadA.start();
        threadB.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.suspend();
        //根据打印结果可以看出，如果A线程在拿到锁的时候被suspend，那么B线程将拿不到锁了
    }
}
