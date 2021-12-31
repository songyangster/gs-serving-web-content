package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.TreeNode;

import java.util.*;

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

    int maxDepth;
    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        traverseDepth(root, 0);
        return maxDepth;
    }

    private void traverseDepth(TreeNode node, int depth) {
        if (node == null) return;
        depth++;
        if (depth > maxDepth) maxDepth = depth;
        traverseDepth(node.left, depth);
        traverseDepth(node.right, depth);
    }

    List<List<Integer>> levelList;
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelList = new ArrayList<>();
        if (root != null) {
            traverseLevel(root, 0);
        }
        return levelList;
    }

    private void traverseLevel(TreeNode node, int depth) {
        while (levelList.size() < depth + 1) {
            levelList.add(new ArrayList<>());
        }
        levelList.get(depth).add(node.val);
        if (node.left != null) traverseLevel(node.left, depth + 1);
        if (node.right != null) traverseLevel(node.right, depth + 1);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == null || q == null) return root;
        LinkedList<TreeNode> pStack = new LinkedList<TreeNode>();
        LinkedList<TreeNode> qStack = new LinkedList<TreeNode>();
        if (findNode(root, p, pStack) && findNode(root, q, qStack)) {
            for (int i = 0; i < Math.min(pStack.size(), qStack.size()); i++) {
                if (pStack.get(i).val != qStack.get(i).val) return pStack.get(i - 1);
            }
        }
        return root;
    }

    private boolean findNode(TreeNode node, TreeNode target, LinkedList<TreeNode> stack) {
        if (target.val == node.val) return true;
        stack.add(node);
        if (goDown(node.left, target, stack)) return true;
        if (goDown(node.right, target, stack)) return true;
        return false;
    }

    private boolean goDown(TreeNode node, TreeNode target, LinkedList<TreeNode> stack) {
        if (node != null) {
            if (findNode(node.left, target, stack)) {
                return true;
            } else {
                stack.removeLast();
            }
        }
        return false;
    }
}
