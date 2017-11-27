package com.qunar.des.algorithm.chain.single.list.basic.cross;

/**
 * Created by abin on 2017/11/27 2017/11/27.
 * algorithm-svr
 * com.qunar.des.algorithm.chain.single.list.basic.cross
 * 两个单链表是否相交
 */
public class SingleListIntersect {
    
    public static boolean haveIntersect(IntersectNode param1, IntersectNode param2){
        IntersectNode node1 = param1;
        IntersectNode node2 = param2;
        while(null != node1.next)
            node1 = node1.next;
        while(null != node2.next)
            node2 = node2.next;
        return node1 == node2;
    }

    public static void main(String[] args) {


        IntersectNode node1 = new IntersectNode(1);
        IntersectNode node2 = new IntersectNode(2);
        IntersectNode node3 = new IntersectNode(3);
        IntersectNode node4 = new IntersectNode(4);
        IntersectNode node5 = new IntersectNode(5);
        IntersectNode node6 = new IntersectNode(6);
        IntersectNode node7 = new IntersectNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node4;
        IntersectNode node11 = new IntersectNode(0);
        IntersectNode node22 = new IntersectNode(9);
        IntersectNode node33 = new IntersectNode(8);
        node11.next = node22;
        node22.next = node33;
        node33.next = node6;

        boolean result = haveIntersect(node1, node7);
        System.out.println("result = " + result);
    }


}

class IntersectNode {
    public int data;
    public IntersectNode next;
    public IntersectNode(int data){
        this.data = data;
    }
}

