package com.example.demo.suanfa.tree;

public class YanZheng2Tree {
    long perNode = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= perNode) {
            return false;
        }
        perNode = root.val;

        return isValidBST(root.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.min(left, right) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if ((root.left == null) || (root.right == null)) {
            return left+right+1;
        }
        return Math.min(left, right) +1;
    }
}
