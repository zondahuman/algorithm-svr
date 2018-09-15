package com.abin.lee.algorithm.leetcode.test.tree;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/9/14.
 * 112. Path Sum
 * https://leetcode.com/problems/path-sum/description/
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0)
            return true;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && sum == root.val)
            return true;
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }

    public boolean hasPathSum3(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && sum == root.val)
            return true;
        sum -= root.val;
        return hasPathSum3(root.left, sum) || hasPathSum3(root.right, sum);
    }

    /**
     * 1
     * /     \
     * 2        3
     * /   \     /  \
     * 3      2  2    4
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        System.out.println("root=" + JsonUtil.toJson(root));
//        boolean list = new PathSum().hasPathSum(root, 6);
//        boolean list = new PathSum().hasPathSum2(root, 6);
        boolean list = new PathSum().hasPathSum3(root, 6);
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
