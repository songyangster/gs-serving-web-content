package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.TreeNode;

import java.util.*;

public class BSTSearch {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ordered = new ArrayList<>();
        inOrdr(root, ordered);
        return ordered;
    }

    private void inOrdr(TreeNode node, List<Integer> ordered) {
        if (node == null) return;
        inOrdr(node.left, ordered);
        ordered.add(node.val);
        inOrdr(node.right, ordered);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        inOrderQ(root, queue, target, k);
        return queue;
    }

    private void inOrderQ(TreeNode node, Queue<Integer> queue, double target, int k) {
        if (node == null) return;
        inOrderQ(node.left, queue, target, k);
        if (queue.size() < k) {
            queue.add(node.val);
        } else if (Math.abs(node.val - target) < Math.abs(queue.peek() - target)) {
            queue.poll();
            queue.add(node.val);
        } else {
            return;
        }
        inOrderQ(node.right, queue, target, k);
    }

    public List<Integer> closestKValuesBad(TreeNode root, double target, int k) {
        int low = (int) target;
        int high = low + 1;

        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        List<Integer> orderedLeft = new ArrayList<>();
        List<Integer> orderedRight = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            if (current.right != null && current.val < low) {
                leftStack.push(current);
                current = current.right;
            } else {
                moveLeft(current, low, orderedLeft);
                current = !leftStack.isEmpty() ? leftStack.pop() : null;
            }
        }

        current = root;
        while (current != null) {
            if (current.val > high) {
                rightStack.push(current);
                current = current.left;
            } else {
                moveRight(current, high, orderedRight);
                current = !rightStack.isEmpty() ? rightStack.pop() : null;
            }
        }

        List<Integer> vals = new ArrayList<>();
        int iR = 0;
        int iL = orderedLeft.size() - 1;
        while (vals.size() < k && (iR < orderedRight.size() || iL >= 0)) {
            if (iR >= orderedRight.size()) {
                vals.add(orderedLeft.get(iL));
                iL--;
            } else if (iL < 0) {
                vals.add(orderedRight.get(iR));
                iR++;
            } else if ((k - orderedLeft.get(iL)) < (orderedRight.get(iR) - k)) {
                vals.add(orderedLeft.get(iL));
                iL--;
            } else {
                vals.add(orderedRight.get(iR));
                iR++;
            }
        }

        return vals;
    }

    private void moveLeft(TreeNode node, int low, List<Integer> orderedLeft) {
        if (node.left != null && node.val > low) {
            moveLeft(node.left, low, orderedLeft);
        } else {
            inOrdr(node, orderedLeft);
        }
    }

    private void moveRight(TreeNode node, int high, List<Integer> orderedRight) {
        if (node.right != null && node.right.val < high) {
            moveRight(node.right, high, orderedRight);
        } else {
            inOrdr(node, orderedRight);
        }
    }

    int count = 0;
    int current = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        inOrdrK(root, k);
        return current;
    }

    private void inOrdrK(TreeNode node, int k) {
        if (node == null || count == k) return;
        inOrdrK(node.left, k);
        if (count == k) return;
        count++;
        current = node.val;
        if (count == k) return;
        inOrdrK(node.right, k);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new LinkedList<>();
        List<TreeNode> qList = new LinkedList<>();
        findNode(root, p, pList);
        findNode(root, q, qList);
        TreeNode current = root;
        for (int i = 0; i < Math.min(pList.size(), qList.size()); i++) {
            current = pList.get(i);
            if (i == pList.size() -1 || i == qList.size() - 1 || pList.get(i + 1).val != qList.get(i + 1).val) {
                break;
            }
        }
        return current;
    }

    private void findNode(TreeNode treeNode, TreeNode targetNode, List<TreeNode> nList) {
        nList.add(treeNode);
        if (targetNode.val == treeNode.val) return;
        if (targetNode.val < treeNode.val) {
            findNode(treeNode.left, targetNode, nList);
        } else {
            findNode(treeNode.right, targetNode, nList);
        }
    }
}
