package com.abin.lee.algorithm.tree.binary.common;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by abin on 2017/11/27 14:23.
 * algorithm-svr
 * com.abin.lee.algorithm.tree.binary.common
 * 二叉树的深度遍历和广度遍历
 */
public class BinaryTreeTraverse {

    /**
     * 二叉树深度遍历
     * @param root
     */
    public static void depthFirstTraverse(TraverseNode root){
        if(null == root)
            return;
        ArrayDeque<TraverseNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TraverseNode current = stack.pop();
            System.out.println("current= " + current.value);
            if(current.right != null)
                stack.push(current.right);
            if(current.left != null)
                stack.push(current.left);
        }
    }
    public static void depthFirstTraverse1(TraverseNode root){
        if(null == root)
            return;
        Stack<TraverseNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TraverseNode current = stack.pop();
            System.out.println("current= " + current.value);
            if(current.right != null)
                stack.push(current.right);
            if(current.left != null)
                stack.push(current.left);
        }
    }

    public static void levelFirstTraverse(TraverseNode root){
        if(null == root)
            return;
        ArrayDeque<TraverseNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TraverseNode node = queue.remove();
            System.out.printf("" + node.value);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);

        }
        System.out.print("\n");
    }

    public static void levelFirstTraverse1(TraverseNode root){
        if(null == root)
            return;
        BlockingQueue <TraverseNode> queue = new LinkedBlockingDeque<>() ;
        queue.add(root);
        while(!queue.isEmpty()){
            TraverseNode node = queue.remove();
            System.out.printf("" + node.value);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);

        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        TraverseNode node1 = new TraverseNode(1);
        TraverseNode node2 = new TraverseNode(2);
        TraverseNode node3 = new TraverseNode(3, node1, node2);
        TraverseNode node4 = new TraverseNode(4);
        TraverseNode node5 = new TraverseNode(5);
        TraverseNode node6 = new TraverseNode(6, node4, node5);
        TraverseNode node7 = new TraverseNode(7, node6, node3);
        System.out.println("TraverseNode1---before = " + JsonUtil.toJson(node7));
        System.out.println("TraverseNode1---depth------------ = ");
        depthFirstTraverse(node7);
        System.out.println("TraverseNode1---depth------------ = ");

        System.out.println("TraverseNode1-------------------level--------------------- = ");
        levelFirstTraverse(node7);
        System.out.println("TraverseNode1-------------------level--------------------- = ");

    }

}

@Getter
@Setter
class TraverseNode {
    public int value;
    public TraverseNode left;
    public TraverseNode right;

    public TraverseNode() {
    }

    public TraverseNode(int value) {
        this.value = value;
    }

    public TraverseNode(int value, TraverseNode left, TraverseNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }


}