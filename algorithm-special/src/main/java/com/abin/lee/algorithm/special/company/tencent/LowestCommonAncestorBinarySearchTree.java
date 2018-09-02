package com.abin.lee.algorithm.special.company.tencent;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by abin on 2018/8/28.
 * 二叉树搜索树寻找最低公共祖先
 * https://blog.csdn.net/lyy_hit/article/details/47686467
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/159254/Easy-solution-in-Java-Beats-100
 */
public class LowestCommonAncestorBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if ((root.val >= p.val && root.val <= q.val) || (root.val >= q.val && root.val <= p.val))
            return root;
        else if (root.val > p.val && root.val > q.val)
            lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val && root.val < q.val)
            lowestCommonAncestor(root.right, p, q);
        return null;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if((p.val <= root.val && q.val >= root.val) || (q.val <= root.val && p.val >= root.val))
            return root;
        if (p.val > root.val)
            return lowestCommonAncestor1(root.right, p , q);
        return lowestCommonAncestor1(root.left, p, q);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor2(root.left, p, q);
        else if (root.val < p.val && root.val < q.val) return lowestCommonAncestor2(root.right, p, q);
        else return root;
    }

    /**
     * 根据排序二叉树的特点，我们可以知道，任何一个根节点，其左子树中的所有节点小于等于根节点，其右子树中的所有节点大于等于根节点。
     * 因此 当取得任何一个节点值的时候 就有三种情况
     * （1）小于等于第一个节点，大于等于第二个节点；或者小于等于第二个节点，大于等于第一个节点（两个节点大小为给定）；此时，该节点就是所求的节点。
     * （2）该节点均小于给定的两个节点，则所有的节点在该节点的右子树中，继续遍历右字数；
     * （3）该节点均大于给定的两个节点，则所有的节点在该节点的左子树中，继续遍历左字数；
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);
        System.out.println("root=" + JsonUtil.toJson(root));
        TreeNode treeNode = new LowestCommonAncestorBinarySearchTree().lowestCommonAncestor(root, root.left.left, root.right.right);
        System.out.println("treeNode=" + JsonUtil.toJson(treeNode));

    }


    @Getter
    @Setter
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
