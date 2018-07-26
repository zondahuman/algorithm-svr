package com.qunar.des.algorithm.nowcoder;

import com.qunar.des.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by abin on 2018/7/26.
 */
public class BinaryTreePrintByRow {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> nodeList = new ArrayList<Integer>();
        if (null == pRoot)
            return list;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.push(pRoot);
        TreeNode last = pRoot;
        TreeNode currentLast = pRoot;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.pop();
            nodeList.add(temp.val);
            if (temp.left != null) {
                queue.push(temp.left);
                currentLast = temp.left;
            }
            if (temp.right != null) {
                queue.push(temp.right);
                currentLast = temp.right;
            }
            if (temp == last) {
                last = currentLast;
                list.add(nodeList);
                nodeList.clear();
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
                TreeNode temp = queue.pop();
                nodeList.add(temp.val);
                if (temp.left != null) {
                    queue.push(temp.left);
                }
                if (temp.right != null) {
                    queue.push(temp.right);
                }
            }
            list.add(nodeList);
        }
        return list;
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
//        ArrayList<ArrayList<Integer>> list = new BinaryTreePrintByRow().Print(t1);
        ArrayList<ArrayList<Integer>> list = new BinaryTreePrintByRow().Print1(t1);
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
