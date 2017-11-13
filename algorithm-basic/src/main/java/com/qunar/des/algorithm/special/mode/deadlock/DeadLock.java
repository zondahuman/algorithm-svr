package com.qunar.des.algorithm.special.mode.deadlock;

/**
 * Created by abin on 2017/11/13 17:25.
 * algorithm-svr
 * com.qunar.des.algorithm.special.mode.deadlock
 */
public class DeadLock implements Runnable{

    private int flag = 0;
    private static Object lock1 = new Object(), lock2 = new Object();

    @Override
    public void run() {
        System.out.println("flag="+flag);
        if(flag == 0){
            synchronized (lock1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("run--lock2---flag = 0");
                }
            }
        }

        if(flag == 1){
            synchronized (lock2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("run--lock1---flag = 1");
                }
            }
        }

    }


    public static void main(String[] args) {
        DeadLock thread1 = new DeadLock();
        DeadLock thread2 = new DeadLock();
        thread1.flag = 0;
        thread2.flag = 1;
        new Thread(thread1).start();
        new Thread(thread2).start();
    }
}
