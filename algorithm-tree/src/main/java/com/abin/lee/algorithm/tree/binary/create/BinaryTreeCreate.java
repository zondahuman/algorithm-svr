package com.abin.lee.algorithm.tree.binary.create;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-14 上午12:47
 */
public class BinaryTreeCreate {
    private Node root;

    public Node addChild(int data,Node node) {
        if (null == node) {
            node = new Node(data);
        } else {
            if (data < node.value) {
                node.left = addChild(data,node.left);
            } else {
                node.right = addChild(data,node.right);
            }
        }
        return node;
    }


    public static void main(String[] args) {
        BinaryTreeCreate binaryTree = new BinaryTreeCreate();
        Node node = null;
        Node node1 = binaryTree.addChild(5, null);
        Node node2 = binaryTree.addChild(2, node1);
        Node node3 = binaryTree.addChild(3, node2);
        Node node4 = binaryTree.addChild(1, node3);
        Node node5 = binaryTree.addChild(4, node4);
        System.out.println("node5=" + JsonUtil.toJson(node5));
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }
    }

}
