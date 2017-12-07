package com.abin.lee.algorithm.chain.single.rreverse.test;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2017/11/26 2017/11/26.
 * algorithm-svr
 * com.abin.lee.algorithm.chain.single.rreverse.test
 * http://blog.csdn.net/guyuealian/article/details/51119499
 */
public class SinglistReverseTest {

    public static void main(String[] args) {
        ReverseNode node1 = new ReverseNode(1);
        ReverseNode node2 = new ReverseNode(2);
        ReverseNode node3 = new ReverseNode(3);
        ReverseNode node4 = new ReverseNode(4);
        node1.next = node2 ;
        node2.next = node3 ;
        node3.next = node4;

        System.out.println("node1 = " + JsonUtil.toJson(node1));
//        ReverseNode result = reverseLoop(node1);
//        System.out.println("result = " + JsonUtil.toJson(result));
//        ReverseNode result1 = reverseRecursive(node1);
//        System.out.println("result1 = " + JsonUtil.toJson(result1));
        ReverseNode result2 = reverseKGroup(node1, 3);
        System.out.println("result2 = " + JsonUtil.toJson(result2));
    }

    public static ReverseNode reverseKGroup(ReverseNode head, int k){
        ReverseNode current = head;
        int count = 0;
        while(null != current && count != k){
            current = current.next;
            count++;
        }
        if(count == k){
            current = reverseKGroup(current, k);
            while(count-- > 0){
                ReverseNode temp = head.next;
                head.next = current;
                current = head;
                head = temp;
            }
            head = current;
        }
        return  head;
    }


    public static ReverseNode reverseLoop(ReverseNode head){
        if(null == head || null == head.next)
            return head;
        ReverseNode previous = head;
        ReverseNode current = head.next;
        ReverseNode temp = null;
        while (null != current){
            temp = current.next;
            current.next = previous ;
            previous = current;
            current = temp;
        }
        head.next = null ;
        return previous;
    }

    /**
     * 递归的方法其实是非常巧的，它利用递归走到链表的末端，然后再更新每一个node的next 值 ,把原来末尾的null，一步一步的往前提，顺带把上一个节点给予当前节点的next。
     *
     * @param head
     * @return
     */
    public static ReverseNode reverseRecursive(ReverseNode head){
        if(null == head || null == head.next)
            return head;
        ReverseNode reHead = reverseRecursive(head.next);
        head.next.next = head ;
        head.next = null;
        return reHead;
    }


}

class ReverseNode {
    public int data;
    public ReverseNode next;
    public ReverseNode(int data){
        this.data = data;
    }
}