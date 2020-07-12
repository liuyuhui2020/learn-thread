package com.h.learn.thread;

import com.h.learn.thread.runnable.RunnableThread;
import com.h.learn.thread.thread.Thread2;

public class ThreadTest {
    public static void main(String[] args) {
        RunnableThread thread1 = new RunnableThread();
        Thread2 thread2 = new Thread2();
        thread1.run();
        thread2.start();
    }
}
