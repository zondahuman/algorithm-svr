package com.qunar.des.algorithm.special.basic.test.queue;

/**
 * Created by abin on 2018/8/28.
 * 循环数组实现队列
 * https://blog.csdn.net/victor_cindy1/article/details/46604575
 */
public class LoopArrayAchieveQueueTest {
    Object[] a; //对象数组，队列最多存储a.length-1个对象
    int front;  //队首下标
    int rear;   //队尾下标

    public LoopArrayAchieveQueueTest() {
        this(10); //调用其它构造方法
    }

    public LoopArrayAchieveQueueTest(int size) {
        a = new Object[size];
        front = 0;
        rear = 0;
    }

    /**
     * 将一个对象追加到队列尾部
     *
     * @param obj 对象
     * @return 队列满时返回false, 否则返回true
     */
    public boolean enqueue(Object obj) {
        if ((rear + 1) % a.length == front) {
            return false;
        }
        a[rear] = obj;
        rear = (rear + 1) % a.length;
        return true;
    }

    /**
     * 队列头部的第一个对象出队
     *
     * @return 出队的对象，队列空时返回null
     */
    public Object dequeue() {
        if (rear == front) {
            return null;
        }
        Object obj = a[front];
        front = (front + 1) % a.length;
        return obj;
    }

    public static void main(String[] args) {
        LoopArrayAchieveQueueTest q = new LoopArrayAchieveQueueTest(4);
        System.out.println(q.enqueue("张三"));
        System.out.println(q.enqueue("李斯"));
        System.out.println(q.enqueue("赵五"));
        System.out.println(q.enqueue("王一"));//无法入队列，队列满
        for (int i = 0; i < 4; i++) {
            System.out.println(q.dequeue());
        }
    }

}
