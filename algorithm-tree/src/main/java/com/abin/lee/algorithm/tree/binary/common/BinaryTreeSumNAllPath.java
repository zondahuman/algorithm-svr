package com.abin.lee.algorithm.tree.binary.common;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

/**
 * Created by abin on 2018/8/10.
 * 找出所有从根节点到叶子节点路径和等于n的路径并输出
 * 一个二叉树，要求从二叉树根节点一直到叶子节点数字之和等于n，给出符合的路径的数量
 * 一个二叉树，每个节点都是数字，给定一个数字n，要求从二叉树根节点一直到叶子节点数字之和等于n，给出符合的路径的数量
 * https://blog.csdn.net/yan456jie/article/details/52016685
 * https://blog.csdn.net/yan456jie/article/details/50967459
 */
public class BinaryTreeSumNAllPath {
    Stack<Node> stack = new Stack<Node>();
    public void findPath(Node root, int k){
        if(root != null){
            stack.push(root);
            k = k - root.value ;
            if(k==0 && root.left==null && root.right==null){
                for (Node no:stack){
                    System.out.print(no.value+"-");
                }
                System.out.println();
            }
            findPath(root.left, k);
            findPath(root.right, k);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.right.left = new Node(2);
        root.right.right = new Node(4);
        System.out.println("root="+ JsonUtil.toJson(root));
        new BinaryTreeSumNAllPath().findPath(root, 6);

    }

    @Setter
    @Getter
    public static class Node{
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
