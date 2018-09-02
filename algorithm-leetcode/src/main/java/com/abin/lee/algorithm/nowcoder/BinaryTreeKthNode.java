package com.abin.lee.algorithm.nowcoder;

import com.abin.lee.algorithm.common.json.jackson.JsonUtil;

/**
 * Created by abin on 2018/7/19.
 * 二叉搜索树的第k个结点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * 二叉排序树又叫二叉查找树或者二叉搜索树，它首先是一个二叉树，而且必须满足下面的条件：
 * 1）若左子树不空，则左子树上所有结点的值均小于它的根节点的值；
 * 2）若右子树不空，则右子树上所有结点的值均大于它的根结点的值
 * 3）左、右子树也分别为二叉排序树
 * https://www.nowcoder.com/profile/644033/codeBookDetail?submissionId=1517189
 * https://blog.csdn.net/gg543012991/article/details/52843158?locationNum=14&fps=1
 *
 */
public class BinaryTreeKthNode {
    int count = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (null != node)
                return node;
            count++;
            if (count == k)
                return pRoot;
            node = KthNode(pRoot.right, k);
            if (node != null)
                return node;
        }
        return null;
    }


    public static void main(String[] args) {
        int[] param = new int[1];
        System.out.println("new int[1]== " + JsonUtil.toJson(param));
        BinaryTreeKthNode solution1 = new BinaryTreeKthNode();

        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(8);
//		TreeNode n8 = new TreeNode(8);
//		TreeNode n9 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

//		n4.left = n8;
//		n4.right = n9;
        System.out.println(" n1= " + JsonUtil.toJson(n1));
        System.out.println("第" + 3 + "大的节点是：");
        TreeNode result = solution1.KthNode(n1, 5);
        System.out.println("result=" + JsonUtil.toJson(result));

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
