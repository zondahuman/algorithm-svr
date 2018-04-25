package com.abin.lee.algorithm.special.mode.producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by abin on 2017/11/13 15:17.
 * algorithm-svr
 * com.qunar.des.algorithm.special.mode.producer
 */
public class PublishSubscibe {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);

    public static void main(String[] args) {
        PublishSubscibe publishSubscibe = new PublishSubscibe();
        Producer producer = publishSubscibe.new Producer();
        Subscribe subscribe = publishSubscibe.new Subscribe();
        new Thread(producer).start();
        new Thread(subscribe).start();

    }

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    if (queue.size() == 5) {
                        try {
                            System.out.println("队列已满，等待空余的空间");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1);
                    queue.notify();
                    System.out.println("向队列取中插入一个元素，队列剩余空间："+(5-queue.size()));

                }
            }
        }
    }
    class Subscribe implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    if (queue.size() == 0) {
                        try {
                            System.out.println("队列为空，等待生产产品");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("从队列中取走一个元素，队列中剩余"+queue.size()+"个");
                }
            }
        }
    }




}
