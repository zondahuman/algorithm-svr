package com.abin.lee.algorithm.tree.binary.find;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-14 上午1:48
 */
public class BinaryTreeFind {
    private Node root;

    public void addChild(int data) {
        Node node = new Node(data);
        if (null == root) {
            root = new Node(data);
        } else {
            Node foucs = root;
            Node parent = null;
            while (true) {
                parent = foucs;
                if (data < foucs.value) {
                    foucs = foucs.left;
                    if (foucs == null) {
                        parent.left = node;
                        return;
                    }
                } else {
                    foucs = foucs.right;
                    if (null == foucs) {
                        parent.right = node;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int data) {
        Node current = root;
        while (data != current.value) {
            if (data < current.value)
                current = current.left;
            else
                current = current.right;
            if (null == current)
                return null;
        }
        return current;
    }

    public void previous(Node tree){
        if(null != tree){
            System.out.println(tree.value+"-");
            previous(tree.left);
            previous(tree.right);
        }
    }
    public void middle(Node tree){
        if(null != tree){
            middle(tree.left);
            System.out.println(tree.value+"-");
            middle(tree.right);
        }
    }
    public void post(Node tree){
        if(null != tree){
            post(tree.left);
            post(tree.right);
            System.out.println(tree.value+"-");
        }
    }


    public static void main(String[] args) {
        BinaryTreeFind binaryTree = new BinaryTreeFind();
        binaryTree.addChild(5);
        binaryTree.addChild(1);
        binaryTree.addChild(3);
        binaryTree.addChild(2);
        binaryTree.addChild(4);
        System.out.println("binaryTree=" + JsonUtil.toJson(binaryTree.root));
        Node findNode = binaryTree.find(3);
        System.out.println("findNode=" + JsonUtil.toJson(findNode));
        binaryTree.middle(binaryTree.root);
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
