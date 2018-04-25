package com.abin.lee.algorithm.chain.single.list.basic.reverse;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-10 下午6:57
 */
public class SingleList {
    private Node header;
    public void addFirst(int data){
        Node current = new Node(data);
        current.next = header;
        header = current;

    }
    public Node recursiveReverse(Node head){
        if(null == head || null == head.next)
            return head;
        Node reverse = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }
    public Node cycleReverse(Node head){
        if(null == head)
            return head;
        Node previous = head;
        Node current = head.next;
        Node next;
        while(null != current){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head.next = null;
        head = previous;
        return head;
    }

    public Node reverse(Node node){
        if(node==null || node.next == null)
            return node;
        Node next = node.next;
        //Node next clear, otherwise the recursive return to the top of the last node to reverse the original list of the next will point to the head node of the original, but the head node of the original next also points to the first node of the original, that is the last node after the reversal, will cause repeated list Unlimited
        node.next = null;
        Node returnNode = reverse(next);
        next.next = node;
        return returnNode;
    }

    public Node reverse1(Node node){
        if(node==null || node.next == null)
            return node;
        Node next = node.next;
        node.next=null;
        Node returnNode = reverse1(next);
        next.next=node;
        return returnNode;
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addFirst(1);
        singleList.addFirst(2);
        singleList.addFirst(3);
        singleList.addFirst(4);
        System.out.println("singleList="+ JsonUtil.toJson(singleList.header));
//        Node cycleNode = singleList.cycleReverse(singleList.header);
//        System.out.println("cycleNode="+ JsonUtil.toJson(cycleNode));
//        Node recursiveNode = singleList.recursiveReverse(singleList.header);
//        System.out.println("recursiveNode="+ JsonUtil.toJson(recursiveNode));
        Node reverseNode = singleList.reverse1(singleList.header);
        System.out.println("recursiveNode="+ JsonUtil.toJson(reverseNode));
    }
}
