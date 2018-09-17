package com.abin.lee.algorithm.leetcode.tree;

/**
 * Created by abin on 2018/9/14.
 * 437. Path Sum III
 * 找到二叉树中的子路径条数使得该子路径权值之和与给定和相等。
 * https://leetcode.com/problems/path-sum-iii/description/
 */
public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        if (null == root) return 0;
        return pathSumDfs(root, sum) + pathSum(root.left, sum)+pathSum(root.right, sum);
    }

    public int pathSumDfs(TreeNode root, int sum) {
        if (null == root) return 0;
        return (root.val == sum ? 1 : 0) + pathSumDfs(root.left, sum - root.val) + pathSumDfs(root.right, sum - root.val);
    }

    /**
     * Example:
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     * 10
     * /  \
     * 5   -3
     * / \    \
     * 3   2   11
     * / \   \
     * 3  -2   1
     * Return 3. The paths that sum to 8 are:
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3. -3 -> 11
     *
     * @param args
     */
    public static void main(String[] args) {

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
