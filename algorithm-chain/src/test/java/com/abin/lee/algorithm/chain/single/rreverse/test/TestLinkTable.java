package com.abin.lee.algorithm.chain.single.rreverse.test;

/**
 * Created by abin on 2017/12/7 15:11.
 * algorithm-svr
 * com.abin.lee.algorithm.chain.single.rreverse.test
 */
public class TestLinkTable {

    public static void main(String[] args) {
        LinkNode head = new LinkNode(1);
        head.setNext(new LinkNode(2)).setNext(new LinkNode(3)).setNext(new LinkNode(4))
                .setNext(new LinkNode(5)).setNext(new LinkNode(6));

        System.out.print("origin:");
        head.print();
        System.out.print("\r\nreverse:");
        reverse(head, 3).print();
    }

    public static LinkNode reverse(LinkNode head, int val) {
        if (head.getVal() == val) {
            return head;
        }
        LinkNode pre = head;
        LinkNode next = head.getNext();
        while (next != null) {
            LinkNode oriNext = next.getNext();
            next.setNext(pre);
            if (next.getVal() != val) {
                pre = next;
                next = oriNext;
                continue;
            } else {
                head.setNext(oriNext);
                return next;
            }
        }
        head.setNext(null);
        return pre;
    }
}

class LinkNode {
    private int val;
    private LinkNode next;
    public LinkNode(int val) {
        this.val = val;
    }
    public LinkNode setNext(LinkNode nextNode) {
        this.next = nextNode;
        return nextNode;
    }
    public void print() {
        LinkNode item = this;
        while (item != null) {
            System.out.print("->" + item.getVal());
            item = item.getNext();
        }
    }
    public int getVal() {
        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }
    public LinkNode getNext() {
        return next;
    }
}