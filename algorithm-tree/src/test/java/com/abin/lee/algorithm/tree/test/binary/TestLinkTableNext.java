package com.abin.lee.algorithm.tree.test.binary;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by abin on 2017/12/7 2017/12/7.
 * algorithm-svr
 * com.abin.lee.tree.binary.test
 *
 */
public class TestLinkTableNext {
    public static void main(String[] args) throws Exception {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.lchild = new BinaryTreeNode(2);
        root.rchild = new BinaryTreeNode(3);
        root.lchild.lchild = new BinaryTreeNode(4);
        root.lchild.rchild = new BinaryTreeNode(5);
        root.rchild.lchild = new BinaryTreeNode(6);
        root.rchild.rchild = new BinaryTreeNode(7);
        root.lchild.lchild.lchild = new BinaryTreeNode(8);

        queue(root);
        BinaryTreeNode t = root;
        while (t != null) {
            System.out.print(t.val);
            BinaryTreeNode n = t.next;
            while (n != null) {
                System.out.print("->" + n.val);
                n = n.next;
            }
            System.out.println();
            t = t.lchild;
        }
    }

    public static void queue(BinaryTreeNode root) throws Exception {
        if (root == null) {
            return;
        }

        LinkedBlockingQueue<BinaryTreeNode> q = new LinkedBlockingQueue<BinaryTreeNode>();
        q.add(root);
        while (q.size() > 0) {
            int size = q.size();
            BinaryTreeNode n = null;
            while (size > 0) {
                BinaryTreeNode t = q.take();
                if (n != null) {
                    n.next = t;
                }
                if (t.lchild != null) {
                    q.add(t.lchild);
                }
                if (t.rchild != null) {
                    q.add(t.rchild);
                }
                n = t;
                size--;
            }
        }
        System.out.println("root="+JsonUtil.toJson(root));
    }
}

class BinaryTreeNode {
    public int val;
    public BinaryTreeNode next;
    public BinaryTreeNode lchild;
    public BinaryTreeNode rchild;
    public BinaryTreeNode(int val) {
        this.val = val;
    }
}