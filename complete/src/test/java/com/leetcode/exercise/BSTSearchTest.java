package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BSTSearchTest {
    BSTSearch bstSearch = new BSTSearch();

    @Test
    public void testInOrder() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        assertEquals("[1, 3, 2]", bstSearch.inorderTraversal(root).toString());

        root = null;
        assertEquals("[]", bstSearch.inorderTraversal(root).toString());

        root = new TreeNode(1);
        assertEquals("[1]", bstSearch.inorderTraversal(root).toString());
    }

    @Test
    public void testClosestKValues() {
        TreeNode root = new TreeNode(1);

        assertEquals("[1]", bstSearch.closestKValues(root, 0.00, 1).toString());

        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);

        assertEquals("[3, 4]", bstSearch.closestKValues(root, 3.714268, 2).toString());

    }
}
