package com.abin.lee.algorithm.tree.binary.common;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by abin on 2017/12/22 2017/12/22.
 * algorithm-svr
 * com.abin.lee.algorithm.tree.binary.common
 * 二叉树算法归纳
 * http://blog.csdn.net/fightforyourdream/article/details/16843303
 */
public class BinaryTreeInduction {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(12);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(13);
        root.right.right = new Node(14);
        root.right.right.left = new Node(15);
        System.out.println("root="+ JsonUtil.toJson(root));
        Integer totalLevel = getSizeByLevel(root);
        System.out.println("totalLevel="+ totalLevel);
        Integer totalDepth = getSizeByDepth(root);
        System.out.println("totalDepth="+ totalDepth);
        Integer totalRecursive = getSizeByRecursive(root);
        System.out.println("totalRecursive="+ totalRecursive);
        Integer maxDepth = getMaxDepth(root);
        System.out.println("maxDepth="+ maxDepth);
    }

    /**
     * 二叉树最大深度
     */
    @Test
    public void testGetMaxDepth(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(12);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(13);
        root.right.right = new Node(14);
        root.right.right.left = new Node(15);
        System.out.println("root="+ JsonUtil.toJson(root));
        Integer maxDepth = getMaxDepth(root);
        System.out.println("maxDepth="+ maxDepth);
    }

    /**
     * 二叉树的节点总个数
     */
    @Test
    public void testGetTotalSize(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(12);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(13);
        root.right.right = new Node(14);
        root.right.right.left = new Node(15);
        System.out.println("root="+ JsonUtil.toJson(root));
        Integer totalLevel = getSizeByLevel(root);
        System.out.println("totalLevel="+ totalLevel);
        Integer totalDepth = getSizeByDepth(root);
        System.out.println("totalDepth="+ totalDepth);
        Integer totalRecursive = getSizeByRecursive(root);
        System.out.println("totalRecursive="+ totalRecursive);
    }

    public static Integer getMaxDepth(Node root){
        if(null == root)
            return 0;
        else
            return Math.max(getMaxDepth(root.left), getMaxDepth(root.right))+1;
    }


    /**
     * 求二叉树总个数(递归)
     * @param root
     * @return
     */
    public static Integer getSizeByRecursive(Node root){
        if(null == root) {
            return 0;
        }else{
            return getSizeByRecursive(root.left) + getSizeByRecursive(root.right) + 1;
        }
    }

    /**
     * 求二叉树总个数(广度遍历)
     * @param root
     * @return
     */
    public static Integer getSizeByLevel(Node root){
        int num = 0;
        if(null == root) {
            return num;
        }else{
            num = 1;
            BlockingQueue<Node> queue = new LinkedBlockingDeque<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                Node node = queue.poll();
                if(null != node.left){
                    queue.offer(node.left);
                    num++;
                }
                if(null != node.right){
                    queue.offer(node.right);
                    num++;
                }
            }
        }
        return num;
    }
    /**
     * 求二叉树总个数(深度遍历)
     * @param root
     * @return
     */
    public static Integer getSizeByDepth(Node root){
        int num = 0;
        if(null == root) {
            return num;
        }else{
            num = 1;
            Stack<Node> stack = new Stack<Node>();
            stack.push(root);
            while(!stack.isEmpty()){
                Node node = stack.pop();
                if(null != node.left){
                    stack.push(node.left);
                    num++;
                }
                if(null != node.right){
                    stack.push(node.right);
                    num++;
                }
            }
        }
        return num;
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
