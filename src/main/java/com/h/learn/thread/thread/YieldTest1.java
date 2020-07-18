package com.h.learn.thread.thread;

/**
 * @ClassName YieldTest1
 * @Description 测试yield：不释放对象锁 而 Object的wait方法则会释放锁
 * @Author Admin
 * @Date 2020/7/18
 * @Version 1.0
 */
public class YieldTest1 {

    private String name;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    synchronized public void setName(String name) {
        this.name = name;
        if ("A".equals(name)) {
            try {
                this.wait(100);//放弃锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A" + System.currentTimeMillis());
        } else {
            System.out.println("B" + System.currentTimeMillis());

        }
    }

    public String getName() {
        return name;
    }


    public static void main(String[] args) {
        YieldTest1 yieldTest1 = new YieldTest1();
        Thread6 thread6A = new Thread6(yieldTest1);
        thread6A.setName("A");
        //设置线程优先级
//        thread6A.setPriority(Thread.MAX_PRIORITY);
        Thread6 thread6B = new Thread6(yieldTest1);
        thread6B.setName("B");
        thread6A.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread6B.start();
        //thread6A.yield();
        System.out.println(yieldTest1.getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(yieldTest1.getName());
    }
}

class Thread6 extends Thread {
    YieldTest1 yieldTest1;

    Thread6(YieldTest1 yieldTest1) {
        this.yieldTest1 = yieldTest1;
    }

    @Override
    public void run() {
        if ("A".equals(Thread.currentThread().getName())) {
            this.yieldTest1.setName("A");
        } else {
            this.yieldTest1.setName("B");
        }
    }
}


