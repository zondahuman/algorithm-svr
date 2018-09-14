package com.abin.lee.algorithm.special.company.tencent;

/**
 * Created by abin on 2018/8/28.
 * Tencent Advertisement
 * 循环数组实现队列
 * https://blog.csdn.net/victor_cindy1/article/details/46604575
 */
public class LoopArrayAchieveQueue {
    Object[] queue;
    int start = 0;
    int end = 0;

    public LoopArrayAchieveQueue() {
        this(10);
    }

    public LoopArrayAchieveQueue(int size) {
        queue = new Object[size];
    }

    public boolean enqueue(Object obj) {
        if ((end + 1) % queue.length == start)
            return false;
        queue[end] = obj;
        end = (end + 1) % queue.length;
        return true;
    }

    public Object dequeue() {
        if (start == end)
            return null;
        Object obj = queue[start];
        start = (start + 1) % queue.length;
        return obj;
    }

    /**
     * 几个重点：
     1、front指向队头，rear指向队尾的下一个位置。
     2、队为空的判断：front==rear；队为满的判断：(rear+1)%MAXSIZE==front。
     front:起始位置
     rear：结束位置
     * @param args
     */
    public static void main(String[] args) {
        LoopArrayAchieveQueue loopQueue = new LoopArrayAchieveQueue(4);
        System.out.println(loopQueue.enqueue("张三"));
        System.out.println(loopQueue.enqueue("李四"));
        System.out.println(loopQueue.enqueue("王五"));
        System.out.println(loopQueue.enqueue("赵六"));//无法入队列，队列满
        for (int i = 0; i < 4; i++) {
            System.out.println(loopQueue.dequeue());
        }
    }

}
