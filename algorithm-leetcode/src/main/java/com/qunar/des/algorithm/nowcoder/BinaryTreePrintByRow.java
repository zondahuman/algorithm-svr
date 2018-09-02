package com.qunar.des.algorithm.nowcoder;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by abin on 2018/7/26.
 * 把二叉树打印成多行
 * 题目描述
 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class BinaryTreePrintByRow {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> nodeList = new ArrayList<Integer>();
        if (null == pRoot)
            return list;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        TreeNode last = pRoot;
        TreeNode currentLast = pRoot;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            nodeList.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
                currentLast = temp.left;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                currentLast = temp.right;
            }
            if (temp == last) {
                list.add(new ArrayList<Integer>(nodeList));
                nodeList.clear();
                last = currentLast;
            }
        }
        return list;
    }

    ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (null == pRoot)
            return list;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.push(pRoot);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> nodeList = new ArrayList<Integer>();
            for (int i = 0; i <size ; i++) {
                TreeNode temp = queue.remove();
                nodeList.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            list.add(nodeList);
        }
        return list;
    }

    ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(pRoot == null)
            return ret;
        queue.add(pRoot);
        int now=1, next=0;
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            now--;
            tmp.add(node.val);
            if(node.left != null){
                queue.add(node.left);
                next++;
            }
            if(node.right!=null){
                queue.add(node.right);
                next++;
            }
            if(now==0){
                ret.add(new ArrayList<>(tmp));
                tmp.clear();
                now = next;
                next = 0;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
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
        ArrayList<ArrayList<Integer>> list = new BinaryTreePrintByRow().Print(t1);
//        ArrayList<ArrayList<Integer>> list = new BinaryTreePrintByRow().Print1(t1);
//        ArrayList<ArrayList<Integer>> list = new BinaryTreePrintByRow().Print2(t1);
        System.out.println("list=" + JsonUtil.toJson(list));
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
