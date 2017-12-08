package com.abin.lee.algorithm.tree.binary.common;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by abin on 2017/12/7 18:56.
 * algorithm-svr
 * com.abin.lee.algorithm.tree.binary.common
 * 题目：对于一颗完全二叉树，要求给所有节点加上一个pNext指针，指向同一层的相邻节点；如果当前节点已经是该层的最后一个节点，则将pNext指针指向NULL；给出程序实现，并分析时间复杂度和空间复杂度。
 运用队列，按层遍历，每次遍历一层时，添加新指针，由于每个节点只需要进队一次出队一次，时间复杂度为O(n)，空间复杂度为O(n)，具体代码如下：
 http://blog.csdn.net/fangjian1204/article/details/38403417
 https://segmentfault.com/a/1190000003465911
 */
public class BinaryTreeAddNext {
    /**
     * 二叉树系列---标记二叉树中每个节点的next指针
     * http://blog.csdn.net/bh_xiaoxinba/article/details/53030689
     * For example,
     Given the following perfect binary tree,
     1
     / \
     2 3
     / \ / \
     4 5 6 7

     After calling your function, the tree should look like:
     1 -> NULL
     / \
     2 -> 3 -> NULL
     / \ / \
     4->5->6->7 -> NULL
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(12);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(13);
        root.right.right = new Node(14);
        System.out.println("root="+ JsonUtil.toJson(root));
//        addNext(root);
//        System.out.println("root="+ JsonUtil.toJson(root));
        //循环
//        AddRightPointerNext(root);
//        System.out.println("root="+ JsonUtil.toJson(root));
        //递归
        addRightNextRecursive(root);
        System.out.println("root="+ JsonUtil.toJson(root));
    }
    public static void addNext(Node node){
        if(null == node)
            return ;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int levelLength = queue.size();
            Node previous = null;
            while (levelLength > 0){
                Node current = queue.remove();
                if(null != previous)
                    previous.next = current;
                if(current.left != null)
                    queue.add(current.left);
                if(null != current.right)
                    queue.add(current.right);
                previous = current;
                levelLength--;
            }
        }
    }

    /**
     * Given a binary tree

     struct TreeLinkNode {
     TreeLinkNode *left;
     TreeLinkNode *right;
     TreeLinkNode *next;
     }
     Populate each next pointer to point to its next right node. If there
     is no next right node, the next pointer should be set to NULL.

     Initially, all next pointers are set to NULL.
     For example, Given the following perfect binary tree,

     1
     /  \
     2    3
     / \  / \
     4  5  6  7
     After calling your function, the tree should look like:

     1 -> NULL
     /  \
     2 -> 3 -> NULL
     / \  / \
     4->5->6->7 -> NULL
     Note:
     https://segmentfault.com/a/1190000003465911
     You may only use constant extra space. You may assume that it is a
     perfect binary tree (ie, all leaves are at the same level, and every
     parent has two children).
     * @param root
     * @throws InterruptedException
     */
    public static void AddRightPointerNext(Node root) throws InterruptedException {
        if(null == root) return;
        BlockingQueue<Node> queue = new LinkedBlockingDeque<>();
        queue.put(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.take();
                if(i < size -1){
                    Node next = queue.peek();
                    current.next = next;
                }
                if(current.left != null)
                    queue.put(current.left);
                if(current.right != null)
                    queue.put(current.right);
            }
        }
    }

    public static void addRightNextRecursive(Node root){
        if(root == null) return;
        //左子节点的next是右子节点
        if(root.left != null)
            root.left.next = root.right;
        //右子节点的next是父节点的next的左子节点
        if(root.right != null)
            root.right.next = root.next == null ? null : root.next.left;
        addRightNextRecursive(root.left);
        addRightNextRecursive(root.right);
    }




    @Getter
    @Setter
    static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }


    }
}

