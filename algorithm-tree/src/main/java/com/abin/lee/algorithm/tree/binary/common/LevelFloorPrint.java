package com.abin.lee.algorithm.tree.binary.common;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by abin on 2018/3/12 21:55.
 * algorithm-svr
 * com.abin.lee.algorithm.tree.binary.common
 * http://blog.csdn.net/dlf123321/article/details/52435111
 * 关于二叉树的按层打印
 */
public class LevelFloorPrint {

    public static void main(String[] args) throws InterruptedException {

//        new LevelFloorPrint().printFloorCommon();
        new LevelFloorPrint().printFloorN();

    }

    public void printFloorCommon() throws InterruptedException {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;
        t5.left = t7;
        t5.right = t8;
//        new LevelFloorPrint().printFloor(t1);
        this.printFloors(t1);
    }

    public void printFloorN() throws InterruptedException {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        TreeNode t12 = new TreeNode(12);
        TreeNode t13 = new TreeNode(13);
        TreeNode t14 = new TreeNode(14);
        TreeNode t15 = new TreeNode(15);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t9;
        t3.left = t5;
        t3.right = t6;
        t4.left = t10;
        t4.right = t11;
        t5.left = t7;
        t5.right = t8;
        t6.left = t12;
        t6.right = t13;
        t7.left = t14;
        t7.right = t15;

        this.printFloors(t1);
    }

    public void printFloor(TreeNode root) throws InterruptedException {
        if (null == root) return;
        BlockingQueue<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.put(root);
        TreeNode last = root;     //当前行的最后节点
        TreeNode nextLast = root;   //下一行的最右节点
        while (!queue.isEmpty()) {
            TreeNode node = queue.take();
            System.out.print(node.val +" ");
            if(node.left != null){
                queue.put(node.left);
                nextLast = node.left ;
            }
            if(node.right != null){
                queue.put(node.right);
                nextLast = node.right;
            }
            if(node == last){
                System.out.println();
                last = nextLast ;
            }
        }
    }


    public void printFloors(TreeNode root) throws InterruptedException {
        if (null == root) return;
        BlockingQueue<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.put(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i <size ; i++) {
                TreeNode node = queue.take();
                System.out.print(node.val +" ");
                if(node.left != null){
                    queue.put(node.left);
                }
                if(node.right != null){
                    queue.put(node.right);
                }
            }
            System.out.println();

        }
    }

    /**
     * 1
     2 3
     4 5 6
     7 8
     */
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
}
