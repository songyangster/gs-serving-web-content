package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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

    private TreeNode newRoot;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        invertOne(root);
        return newRoot;
    }

    private void invertOne(TreeNode node) {
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left == null) {
            newRoot = node;
            return;
        }
        invertOne(left);
        left.left = right;
        left.right = node;
        node.left = null;
        node.right = null;
    }

    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
    public int findSecondMinimumValue(TreeNode root) {
        queue.clear();
        traverseTree(root);
        return queue.size() == 2 ? queue.poll() : -1;
    }

    private void traverseTree(TreeNode node) {
        if (node == null) return;
        if(!queue.contains(node.val)) queue.add(node.val);
        if (queue.size() == 3) {
            queue.poll();
        }
        traverseTree(node.left);
        traverseTree(node.right);
    }
}
