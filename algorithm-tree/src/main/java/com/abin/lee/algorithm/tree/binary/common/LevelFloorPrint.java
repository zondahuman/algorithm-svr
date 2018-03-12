package com.abin.lee.algorithm.tree.binary.common;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by abin on 2018/3/12 21:55.
 * algorithm-svr
 * com.abin.lee.algorithm.tree.binary.common
 * 关于二叉树的按层打印
 */
public class LevelFloorPrint {

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(7);
        TreeNode t8=new TreeNode(8);

        t1.left=t2;  t1.right=t3;
        t2.left=t4;  t3.left=t5; t3.right=t6;
        t5.left=t7;  t5.right=t8;
        new LevelFloorPrint().printFromTopToBottom(t1);

    }

    public void printFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue=new ArrayBlockingQueue<>(100);
        TreeNode last=root;     //当前行的最后节点
        TreeNode nLast=root;    //下一行的最右节点
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode out=queue.poll();
            System.out.print(out.val+" ");
            if (out.left!=null) {
                queue.add(out.left);
                nLast=out.left;
            }
            if (out.right!=null) {
                queue.add(out.right);
                nLast=out.right;
            }
            if (out==last) {
                System.out.println("");
                last=nLast;
            }

        }
    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
}
