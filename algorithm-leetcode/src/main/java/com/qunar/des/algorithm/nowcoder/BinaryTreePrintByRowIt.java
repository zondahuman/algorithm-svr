package com.qunar.des.algorithm.nowcoder;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by abin on 2018/7/26.
 * 按之字形顺序打印二叉树
 * 题目描述
 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class BinaryTreePrintByRowIt {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> nodeList = new ArrayList<Integer>();
        if (null == pRoot)
            return list;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        TreeNode last = pRoot;
        TreeNode currentLast = pRoot;
        int count = 0;
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
                if(count%2 == 0) {
                    list.add(new ArrayList<Integer>(nodeList));
                }else{
                    ArrayList<Integer> nodeList1 = new ArrayList<Integer>();
                    for (int i = nodeList.size()-1; i >0 ; i--) {
                        nodeList1.add(nodeList.get(i));
                    }
                    list.add(new ArrayList<Integer>(nodeList1));
                }
                nodeList.clear();
                last = currentLast;
                count++;
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
        ArrayList<ArrayList<Integer>> list = new BinaryTreePrintByRowIt().Print(t1);
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
