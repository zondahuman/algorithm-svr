package com.qunar.des.algorithm.chain.single.list.basic.reverse;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by abin on 2017/12/7 14:16.
 * algorithm-svr
 * com.qunar.des.algorithm.chain.single.list.basic.reverse
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 */
public class SingleChainReverse {
    /**
     * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
     k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
     You may not alter the values in the nodes, only nodes itself may be changed.
     Only constant memory is allowed.
     For example,
     Given this linked list: 1->2->3->4->5
     For k = 2, you should return: 2->1->4->3->5
     For k = 3, you should return: 3->2->1->4->5
     * @param args
     */
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        System.out.println("node1=" + JsonUtil.toJson(node1));

//        Node result = reverse(node1);
//        System.out.println("result="+ JsonUtil.toJson(result));
        Node result = reverseKGroup(node1, 3);
        System.out.println("result=" + JsonUtil.toJson(result));
    }

    public static Node reverse(Node node) {
        Node previous = node;
        Node current = node.next;
        Node temp = null;
        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        node.next = null;
        return previous;
    }

    public static Node reverseKGroup(Node head, int k) {
        Node curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                Node tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }


}
