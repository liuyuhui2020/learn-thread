package com.h.learn.thread.thread;

/**
 * @ClassName TestStopThread
 * @Description 测试stop方法
 * @Author Admin
 * @Date 2020/7/12
 * @Version 1.0
 */
public class TestStopThread extends Thread {

    private int i;
    private int j;

    public static void main(String[] args) {
        TestStopThread thread = new TestStopThread();
        thread.start();
        try {
            thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
        //从打印结果可以看出stop方法可能导致共享变量数据不一致的问题，
        // 即在执行到sleep时，线程已经被强制 stop了，后面的代码还未执行
        System.out.println(thread.getI());//999
        System.out.println(thread.getJ());//0
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            setI(i);
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000; i++) {
            setJ(i);
        }
        //如果中断的线程有sleep方法，会抛出InterruptedException
        //如果没有sleep方法，则不会抛异常
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
