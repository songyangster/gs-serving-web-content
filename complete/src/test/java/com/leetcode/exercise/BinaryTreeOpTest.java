package com.leetcode.exercise;

import com.leetcode.exercise.utilities.Codec;
import com.leetcode.exercise.datastructure.TreeNode;
import com.leetcode.exercise.utilities.TreeNodeCoverter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeOpTest {
    BinaryTreeOp binaryTreeOp = new BinaryTreeOp();
    TreeNodeCoverter treeNodeCoverter = new TreeNodeCoverter();

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

    Codec codec = new Codec();
    @Test
    public void testTreeNode () {
        String json = "[3,5,1,6,2,0,8,null,null,7,4]";
        validate(json);

        json = "[1,2,3,null,null,4,5,6,7]";
        validate(json);

        json = "[1]";
        validate(json);

        json = "[1,2]";
        validate(json);
    }

    private void validate(String json) {
        TreeNode root;
        root = codec.deserialize(json);
        assertEquals(json, codec.serialize(root));
    }

    @Disabled
    @Test
    public void testLowestCommonAncestory() {
        TreeNode root = codec.deserialize("[3,5,1,6,2,0,8,null,null,7,4]");
        assertEquals(root.left.val, binaryTreeOp.lowestCommonAncestor(root, root.left,root.left.right.right).val);
    }
}
