package com.abin.lee.algorithm.chain.doubles.list.basic.operate;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by abin on 2018/9/2.
 * 双向链表操作
 * https://www.cnblogs.com/snowwang/p/6074577.html
 * https://blog.csdn.net/lsly521/article/details/79208301
 * https://blog.csdn.net/lovoo/article/details/51771321
 * <p>
 * 这里双向链表，头结点和末节点虽然初始化了-1，-2，没有实际意义，只是为了初始化，实际它里面可以不放置任何东西，
 * 不参与运算，只是为了运算简单化
 */
public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int count;

    public int size() {
        return this.count;
    }

    public boolean empty() {
        return this.count == 0;
    }

    /**
     * 要对链表进行判断，如果为空则设置尾节点为新添加的节点，如果不为空，还要设置头节点的一个前节点为新节点
     *
     * @param obj
     * @return
     */
    public boolean addHead(int obj) {
        Node node = new Node(obj);
        if (null == head) {
            head = new Node(-1, null, null);
            this.head.next = node;
            node.pre = head;
            if (null == tail) {
                tail = new Node(-2, null, null);
            }
            tail.pre = node;
            node.next = tail;
        } else {
            this.head.next.pre = node;
            node.next = head.next;

            this.head.next = node;
            node.pre = head;

        }
        count++;
        return true;
    }

    public Node getNode(int index) {
        if (index == 0)
            return head.next;
        if (index == count)
            return tail.pre;
        int length = 0;
        Node node = head;
        for (int i = 0; i < count; i++) {
            node = node.next;
            ++length;
            if (length == index)
                return node;
        }
        return null;
    }

    public Node getLastNode(int lastIndex) {
        if (lastIndex == 0)
            return tail.pre;
        if (lastIndex == count)
            return head.next;
        int length = 0;
        Node node = tail;
        for (int i = 0; i < count; i++) {
            node = node.pre;
            ++length;
            if (length == lastIndex)
                return node;
        }
        return null;
    }


    public boolean addTail(int obj) {
        Node node = new Node(obj);

        tail.pre.next = node;
        node.pre = tail.pre;

        node.next = tail;
        tail.pre = node;

        count++;
        return true;
    }

    //在指定位置插入元素
    public boolean addDataByIndex(int index, int obj) {
        int length = 0;
        Node node = head;
        for (int i = 0; i < count; i++) {
            node = node.next;
            ++length;
            if (length == index) {
                if (null != node) {
                    Node inode = new Node(obj);
                    node.next.pre = inode;
                    inode.next = node.next;
                    node.next = inode;
                    inode.pre = node;
                    return true;
                }
            }
        }
        return false;
    }

    //在指定位置插入元素
    public boolean addByIndex(int index, int obj) {
        int length = 0;
        Node newNode = new Node(obj);
        if (0 == index) {
            head.next.pre = newNode;
            newNode.next = head.next;
            head.next = newNode;
            newNode.pre = head;
        } else {
            Node node = head;
            //index必须小于双链表的count长度，否则返回false
            while (node != null && index < count) {
                node = node.next;
                length++;
                if (length == index) {
                    node.next.pre = newNode;
                    newNode.next = node.next;
                    node.next = newNode;
                    newNode.pre = node;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeDataByIndex(int index) {
        int length = 0;
        if (index == 0) {
            return false;
        } else {
            Node node = head;
            for (int i = 0; i < count; i++) {
                node = node.next;
                ++length;
                if (length == index) {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                    return true;
                }
            }
        }
        return false;
    }


    public boolean removeByIndex(int index) {
        int length = 0;
        if (index == 0) {
            return false;
        } else {
            Node node = head;
            //index必须小于双链表的count长度，否则返回false
            while (node != null && index < count) {
                node = node.next;
                ++length;
                if (length == index) {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addHead(1);
        doubleLinkedList.addHead(3);
        doubleLinkedList.addHead(5);
        doubleLinkedList.addHead(7);
        doubleLinkedList.addHead(9);
//        doubleLinkedList.addTail(2);

        System.out.println("doubleLinkedList.head=" + JsonUtil.toJson(doubleLinkedList.head));
        System.out.println("doubleLinkedList.tail=" + JsonUtil.toJson(doubleLinkedList.tail));

        Node node1 = doubleLinkedList.getNode(1);
        System.out.println("node1=" + node1.toString());

        Node node4 = doubleLinkedList.getNode(4);
        System.out.println("node4=" + node4.toString());

        Node nodeLast1 = doubleLinkedList.getLastNode(1);
        System.out.println("nodeLast1=" + nodeLast1.toString());

        Node nodeLast4 = doubleLinkedList.getLastNode(4);
        System.out.println("nodeLast4=" + nodeLast4.toString());

        DoubleLinkedList doubleLinkedList2 = new DoubleLinkedList();
        doubleLinkedList2.addHead(11);
        doubleLinkedList2.addHead(33);
        doubleLinkedList2.addHead(55);
        doubleLinkedList2.addDataByIndex(2, 777);
        System.out.println("doubleLinkedList2.head=" + doubleLinkedList2.head.toString());
        doubleLinkedList2.addByIndex(2, 888);
        System.out.println("doubleLinkedList2.head=" + doubleLinkedList2.head.toString());


        DoubleLinkedList doubleLinkedList3 = new DoubleLinkedList();
        doubleLinkedList3.addHead(111);
        doubleLinkedList3.addHead(333);
        doubleLinkedList3.addHead(555);
        doubleLinkedList3.addHead(777);
        doubleLinkedList3.removeDataByIndex(3);
        System.out.println("doubleLinkedList3.head=" + doubleLinkedList3.head.toString());

        boolean flag = doubleLinkedList3.removeByIndex(5);
        System.out.println("flag=" + flag);
        System.out.println("doubleLinkedList3.head=" + doubleLinkedList3.head.toString());

    }


    public static class Node {
        int val;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node node) {
            this.pre = node;
            this.next = node;
        }

        public Node(int val, Node pre, Node next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("val", val)
                    .append("pre", pre)
                    .append("next", next)
                    .toString();
        }
    }
}
