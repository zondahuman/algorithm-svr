package com.abin.lee.algorithm.chain.single.reverse.test;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2017/11/26 2017/11/26.
 * algorithm-svr
 * com.abin.lee.algorithm.chain.single.rreverse.test
 * http://blog.csdn.net/lavor_zl/article/details/42784247
 * http://blog.csdn.net/u011373710/article/details/54024366
 * https://www.cnblogs.com/xudong-bupt/p/3667729.html
 */
public class SingleListRingTest {
    public static void main(String[] args) {
        RingNode node1 = new RingNode(1);
        RingNode node2 = new RingNode(2);
        RingNode node3 = new RingNode(3);
        RingNode node4 = new RingNode(4);
        RingNode node5 = new RingNode(5);
        RingNode node6 = new RingNode(6);
        node1.next = node2 ;
        node2.next = node3 ;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node2;
        boolean result = haveRing(node1);
        System.out.println("result = " + result);
        RingNode entrance = ringEntrance(node1);
        System.out.println("entrance = " + entrance.data);
        int ringlength = ringlength(node1);
        System.out.println("ringlength = " + ringlength);
    }

    public static int ringlength(RingNode head){
        int length = 0;
        //单链表为空时，单链表没有环, 单链表中只有头结点，而且头结点的next为空，单链表没有环
        if(null == head || null == head.next)
            return 0;
        RingNode slow = head.next; //slow表示从头结点开始每次往后走一步的指针
        RingNode fast = head.next.next; //fast表示从头结点开始每次往后走两步的指针
        while(null != fast){ //fast不为空执行while循环
            if(slow == fast) {//slow与fast相等，单链表有环
                System.out.println("slow="+slow.data);
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = fast.next;
        while(slow != fast){
            fast = fast.next;
            length++;
        }
        return length;
    }



    /**
     * 环的入口
     *设问题1中的相遇点为m1，赋值p=m1,q=h，其中h为链表头结点，然后p,q每次1步向前运动，p,q再次相遇所在的位置就是环的入口节点(环的连接点)。
     * 这里和上面提到的博客中的叙述差别非常大，这也是其有些问题的地方，我在这里更正了其说法，并给出了相对严格的证明。
     * @param head
     * @return
     */
    public static RingNode ringEntrance(RingNode head){
        //单链表为空时，单链表没有环, 单链表中只有头结点，而且头结点的next为空，单链表没有环
        if(null == head || null == head.next)
            return null;
        RingNode slow = head.next; //slow表示从头结点开始每次往后走一步的指针
        RingNode fast = head.next.next; //fast表示从头结点开始每次往后走两步的指针
        while(null != fast){ //fast不为空执行while循环
            if(slow == fast) {//slow与fast相等，单链表有环
                System.out.println("slow="+slow.data);
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while(null != fast){
            if(fast == slow)
                return fast;
            slow = slow.next;
            fast = fast.next;
        }
        return null;
    }

    /**
     * 链表是否有环
     * 使用追赶的方法，设定两个指针slow、fast，均从头指针开始，每次分别前进1步、2步。如存在环，则两者相遇；如不存在环，fast遇到NULL退出。其中主要的思想就是“环形相遇追及问题”，理解上应该不复杂。
     * @param head
     * @return
     */
    public static Boolean haveRing(RingNode head){
        //单链表为空时，单链表没有环, 单链表中只有头结点，而且头结点的next为空，单链表没有环
        if(null == head || null == head.next)
            return false;
        RingNode slow = head.next; //slow表示从头结点开始每次往后走一步的指针
        RingNode fast = head.next.next; //fast表示从头结点开始每次往后走两步的指针
        while(null != fast){ //fast不为空执行while循环
            if(slow == fast) {//slow与fast相等，单链表有环
                System.out.println("slow="+slow.data);
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static RingNode haveRingNode(RingNode head){
        if(null == head || null == head.next)
            return null;
        return null;
    }

    static class RingNode {
        public int data;
        public RingNode next;
        public RingNode(int data){
            this.data = data;
        }
    }
    
}



