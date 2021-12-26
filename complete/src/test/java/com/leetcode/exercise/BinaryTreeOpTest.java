package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeOpTest {
    @Test
    public void testBinaryTreeOp () {
        BinaryTreeOp binaryTreeOp = new BinaryTreeOp();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        assertEquals(4, binaryTreeOp.upsideDownBinaryTree(root).val);
    }
}
