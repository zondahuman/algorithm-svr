package com.qunar.des.algorithm.special.basic.test.queue;

/**
 * Created by abin on 2018/8/28.
 * 循环数组实现队列
 * https://blog.csdn.net/victor_cindy1/article/details/46604575
 */
public class LoopArrayAchieveQueueTest1 {
    private Object[] queue;
    int start = 0;
    int end = 0;

    public LoopArrayAchieveQueueTest1() {
        this(3);
    }

    public LoopArrayAchieveQueueTest1(int size) {
        queue = new Object[size];
    }

    public boolean enqueue(Object obj) {
        if ((end + 1) % queue.length == start) {
            return false;
        }
        queue[end] = obj;
        end = (end + 1) % queue.length;
        return true;
    }

    public Object dequeue(){
        if(start == end){
            return null;
        }
        Object obj = queue[start];
        start = (start+1) % queue.length;
        return obj;
    }
    public static void main(String[] args) {
        LoopArrayAchieveQueueTest1 q = new LoopArrayAchieveQueueTest1(4);
        System.out.println(q.enqueue("张三"));
        System.out.println(q.enqueue("李斯"));
        System.out.println(q.enqueue("赵五"));
        System.out.println(q.enqueue("王一"));//无法入队列，队列满
        for (int i = 0; i < 4; i++) {
            System.out.println(q.dequeue());
        }
    }

}
