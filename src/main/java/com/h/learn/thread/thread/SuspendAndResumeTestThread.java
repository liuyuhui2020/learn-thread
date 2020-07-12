package com.h.learn.thread.thread;

/**
 * @ClassName SuspendAndResumeTestThread
 * @Description TODO
 * @Author Admin
 * @Date 2020/7/12
 * @Version 1.0
 */
public class SuspendAndResumeTestThread extends Thread {
    int i = 0;
    int j = 0;

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

    @Override
    public void run() {
        while (true) {
            i++;
            setI(i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setJ(i);
        }


    }

    public static void main(String[] args) {
        SuspendAndResumeTestThread thread = new SuspendAndResumeTestThread();
        thread.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.suspend();
        System.out.println("suspend 时的值为：" + thread.getI());//1
        System.out.println("suspend 时的值为：" + thread.getJ());//0
        thread.resume();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //从打印结果可以看出，suspend方法可能时共享数据不一致，同时suspend方法不会释放同步锁
        System.out.println("resume后的值为：" + thread.getI());//3
        System.out.println("resume后的值为：" + thread.getJ());//2
    }
}
