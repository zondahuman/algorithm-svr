package com.abin.lee.algorithm.leetcode.tree;

import java.util.Stack;

/**
 * Created by abin on 2018/9/14.
 * 112. Path Sum
 * https://leetcode.com/problems/path-sum/description/
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                if (node.val == sum)
                    return true;
            }
            if (node.left != null) {
                node.left.val = node.val + node.left.val;
                stack.push(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val + node.right.val;
                stack.push(node.right);
            }
        }
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum)
            return true;
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }

    public boolean hasPathSum3(TreeNode root, int sum) {
        if(root == null) return false;
        Stack<TreeNode> nodestack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        nodestack.push(root);
        numStack.push(sum);
        while(!nodestack.isEmpty()){
            TreeNode node = nodestack.pop();
            int num = numStack.pop();
            if(node.left == null && node.right == null && num == node.val)
                return true;
            if(node.left != null){
                nodestack.push(node.left);
                numStack.push(num - node.val);
            }
            if(node.right != null){
                nodestack.push(node.right);
                numStack.push(num - node.val);
            }
        }
        return false;
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
