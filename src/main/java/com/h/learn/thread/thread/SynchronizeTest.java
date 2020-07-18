package com.h.learn.thread.thread;

/**
 * @ClassName SynchronizeTest
 * @Description 测试多线程synchonrize
 * @Date 2020/7/18
 * @Version 1.0
 */
public class SynchronizeTest {
    private String name;
    private String password;

    public String getPassword() {
        return password;
    }

    synchronized public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    synchronized public void setName(String name) {
        this.name = name;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        SynchronizeTest synchronizeTest = new SynchronizeTest();
        SynchronizeClass1 threadA = new SynchronizeClass1(synchronizeTest);
        threadA.setName("A");
        SynchronizeClass1 threadB = new SynchronizeClass1(synchronizeTest);
        threadB.setName("B");
        threadA.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
    }

}

class SynchronizeClass1 extends Thread {
    private SynchronizeTest synchronizeTest;

    SynchronizeClass1(SynchronizeTest synchronizeTest) {
        this.synchronizeTest = synchronizeTest;
    }

    @Override
    public void run() {
        if ("A".equals(this.getName())) {
//第一个线程访问对象的synchronize方法时，会获得对象锁，第二个线程执行该对象的另一个synchronize方法时也需要等待上一个线程释放锁，但执行非synchronize方法，则不需要等待
            synchronizeTest.setName("A");
            System.out.println("A name = " + this.synchronizeTest.getName());
        } else {
            synchronizeTest.setPassword(Thread.currentThread().getName());
            System.out.println("B password = " + this.synchronizeTest.getPassword());
        }
    }
}