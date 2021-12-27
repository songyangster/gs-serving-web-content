package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeOpTest {
    BinaryTreeOp binaryTreeOp = new BinaryTreeOp();

    @Test
    public void testBinaryTreeOp () {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        assertEquals(4, binaryTreeOp.upsideDownBinaryTree(root).val);
    }

    @Test
    public void testSecondMinimum() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(5);

        assertEquals(5, binaryTreeOp.findSecondMinimumValue(root));
    }
}
