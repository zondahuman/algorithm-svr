package com.abin.lee.algorithm.nowcoder;

/**
 * Created by abin on 2018/7/19.
 */
public class BinaryTreeIsBalanced {

    /**
     * nowcoder
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right))>1)
            return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right) ;
    }

    /**
     * leecode
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right))>1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right) ;
    }

    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
