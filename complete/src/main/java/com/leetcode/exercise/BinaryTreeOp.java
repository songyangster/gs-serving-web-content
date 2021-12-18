package com.leetcode.exercise;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeOp {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leaves = new ArrayList<>();
        travese(root, leaves);
        return leaves;
    }

    public int travese(TreeNode node, List<List<Integer>> leaves) {
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left == null && right == null) {
            addArray(leaves, 0);
            leaves.get(0).add(node.val);
            return 1;
        }
        int lLeft = travese(left, leaves);
        int lRight = travese(right, leaves);
        int lMax = Math.max(lLeft, lRight);
        addArray(leaves, lMax);
        leaves.get(lMax).add(node.val);
        return lMax + 1;
    }

    public void addArray(List<List<Integer>> leaves, int level) {
        if (leaves.size() < level + 1) {
            for (int i = leaves.size(); i < level + 1; i++) {
                leaves.add(new ArrayList<>());
            }
        }
    }
}
