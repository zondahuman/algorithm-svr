package com.abin.lee.algorithm.leetcode.tree;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by abin on 2018/9/12.
 * 100. Same Tree, 是否是同一棵树
 * https://leetcode.com/problems/same-tree/description/
 * 参加或运算的两个对象只要有一个为1，其值为1。
 *
 * 运算规则：0|0=0；   0|1=1；   1|0=1；    1|1=1；
 */
public class SameTree {
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        Stack<TreeNode> pstack = new Stack<>();
        Stack<TreeNode> qstack = new Stack<>();
        TreeNode curP = p, curQ = q;
//        while (curP != null && curQ != null) {
        while (curP != null && curQ != null || (!pstack.isEmpty() && !qstack.isEmpty())) {
            while (curP != null || curQ != null) {
                if(curP == null || curQ == null || curP.val != curQ.val)
                    return false;
                pstack.add(curP);
                curP = curP.left;
                qstack.add(curQ);
                curQ = curQ.left;
            }
            curP  = pstack.pop();
            curP = curP.right;
            curQ =qstack.pop();
            curQ = curQ.right;
        }
        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public boolean isSameTree3(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        Stack<TreeNode> stackP = new Stack<>(), stackQ = new Stack<>();
        TreeNode currP = p, currQ = q;
        while((currP != null && currQ != null) || (!stackP.isEmpty() && !stackQ.isEmpty())){
            while(currP != null || currQ != null){
                if(currP == null || currQ == null || currP.val != currQ.val) return false;    //check if root node q==p
                stackP.push(currP);
                currP = currP.left;
                stackQ.push(currQ);
                currQ = currQ.left;
            }
            currP = stackP.pop();    //when exit while loop p==q==null, now turn back to its parent which is the last left node.
            currQ = stackQ.pop();
            currP = currP.right;  // traverse to right
            currQ = currQ.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println("root=" + JsonUtil.toJson(root));

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("root1=" + JsonUtil.toJson(root1));

        boolean min = new SameTree().isSameTree2(root, root1);
//        boolean min = new SameTree().isSameTree(root, root1);
        System.out.println("min=" + JsonUtil.toJson(min));

        boolean flag1 = false;
        boolean flag2 = false;
        if (flag1 || flag2) {
            System.out.println("-----------------");
        } else {
            System.out.println("==================");
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
