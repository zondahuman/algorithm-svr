package com.abin.lee.algorithm.leetcode.tree;

/**
 * Created by abin on 2018/7/19.
 * 111. Minimum Depth of Binary Tree
   https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/148847/JAVA-recursive-BFS-DFS(iterative)-solution
   https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null)
            return minDepth(root.right)+1;
        if(root.right == null)
            return minDepth(root.left)+1;
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
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
