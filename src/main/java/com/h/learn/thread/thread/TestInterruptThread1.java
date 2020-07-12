package com.h.learn.thread.thread;

/**
 * @ClassName TestInterruptThread1
 * @Description 测试interrupt interrupted isInterrupted
 * @Author Admin
 * @Date 2020/7/12
 * @Version 1.0
 */
public class TestInterruptThread1 extends Thread {
    public static void main(String[] args) {
        Thread thread = new TestInterruptThread1();
        thread.start();
        thread.interrupt();
        for (int i = 0; i < 1000; i++) {
            //System.out.println(i);
        }
//        System.out.println(thread.isInterrupted());
//        System.out.println(thread.isInterrupted());
        Thread.currentThread().interrupt();
//        System.out.println(Thread.interrupted());
//        System.out.println(Thread.interrupted());
//        System.out.println(Thread.interrupted());
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            //.isInterrupted() 只是查询线程的中断的状态，不会清除
            //.interrupt 在第一次调用时，返回true并把线程中状态清除掉（修改为false）

//            if (this.interrupted()) {
//                System.out.println("线程中断状态true时 J=" + i);
//            } else {
//                System.out.println("线程中断状态false时 J=" + i);
//            }
            if (this.isInterrupted()) {
                System.out.println("线程中断状态true时 J=" + i);
            } else {
                System.out.println("线程中断状态false时 J=" + i);
            }
        }
    }

}
