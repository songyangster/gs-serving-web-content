package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.BinarySearchTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    BinarySearchTree<Integer> bt = createIntegerBinarySearchTree();

    @Test
    public void testBinaryTree() {

        assertTrue(bt.getNode(6) != null);
        assertTrue(bt.getNode(4) != null);

        assertFalse(bt.getNode(1) != null);

        assertTrue(bt.getNode(9) != null);
        bt.delete(9);
        assertTrue(bt.getNode(9) == null);

        bt.traverseInOrder();
        System.out.println("\n");
        bt.traversePreOrder();
        System.out.println("\n");
        bt.traversePostOrder();
        System.out.println("\n");

        assertEquals(8, bt.traverseInOrder(8).getValue());
        assertEquals(8, bt.traversePreOrder(8).getValue());
        assertEquals(8, bt.traversePostOrder(8).getValue());
        assertNull(bt.traversePostOrder(20));

        assertEquals(8, bt.traverseLevelOrder(8).getValue());
        assertNull(bt.traverseLevelOrder(20));
    }

    private BinarySearchTree<Integer> createIntegerBinarySearchTree() {
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();

        bt.insert(6);
        bt.insert(4);
        bt.insert(8);
        bt.insert(3);
        bt.insert(5);
        bt.insert(7);
        bt.insert(9);
        return bt;
    }

}
