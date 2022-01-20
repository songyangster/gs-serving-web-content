package com.leetcode.exercise.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable> {
    Node<T> root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void insert(T value) {
        root = addRecursive(root, value);
    }

    public Node<T> getNode(T value) {
        return containsNodeRecursive(root, value);
    }

    public void delete(T value) {
        root = deleteRecursive(root, new Node<>(value));
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }

    public void traverseInOrder() {
        traverseInOrder(root, null);
    }

    public void traversePreOrder() {
        traversePreOrder(root, null);
    }

    public void traversePostOrder() {
        traversePostOrder(root, null);
    }

    public void traverseLevelOrder() {
        traverseLevelOrder(root, null);
    }

    public Node<T> traverseInOrder(T value) {
        return traverseInOrder(root, value);
    }

    public Node<T> traversePreOrder(T value) {
        return traversePreOrder(root, value);
    }

    public Node<T> traversePostOrder(T value) {
        return traversePostOrder(root, value);
    }

    public Node<T> traverseLevelOrder(T value) {
        return traverseLevelOrder(root, value);
    }

    public Node<T> traverseInOrder(Node<T> node, T value) {
        Node<T> val = null;
        if (node != null) {
            val = foundtNode(node, value);
            if (val != null) return val;
            val = traverseInOrder(node.left, value);
            if (val != null) return val;
            System.out.print(" " + node);
            val = traverseInOrder(node.right, value);
        }
        return val;
    }

    public Node<T> traversePreOrder(Node<T> node, T value) {
        Node<T> val = null;
        if (node != null) {
            System.out.print(" " + node);
            val = foundtNode(node, value);
            if (val != null) return val;
            val = traversePreOrder(node.left, value);
            if (val != null) return val;
            val = traversePreOrder(node.right, value);
        }
        return val;
    }

    public Node<T> traversePostOrder(Node<T> node, T value) {
        Node<T> val = null;
        if (node != null) {
            val = foundtNode(node, value);
            if (val != null) return val;
            val = traversePostOrder(node.left, value);
            if (val != null) return val;
            val = traversePostOrder(node.right, value);
            if (val != null) return val;
            System.out.print(" " + node);
        }
        return val;
    }

    public Node<T> traverseLevelOrder(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        Node val = null;
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(node);

        while (!nodes.isEmpty()) {
            Node nd = nodes.remove();
            val = foundtNode(nd, value);
            if (val != null) return val;
            System.out.print(" " + nd);
            if (nd.left != null) {
                nodes.add(nd.left);
            }
            if (nd.right != null) {
                nodes.add(nd.right);
            }
        }

        return val;
    }

    private Node<T> foundtNode(Node<T> node, T value) {
        if (value != null && value.equals(node.value)) {
            System.out.println(" Found matching Node: " + node);
            return node;
        }
        return null;
    }

    private Node<T> addRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    private Node<T> containsNodeRecursive(Node<T> current, T value) {
        if (current == null || value == null) {
            return null;
        }
        if (value.compareTo(current.value) == 0) {
            return current;
        }
        return value.compareTo(current.value) < 0
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    private Node<T> deleteRecursive(Node<T> current, Node<T> node) {
        if (current == null || node == null) {
            return null;
        }

        if (node.value.compareTo(current.value) == 0) {
            // Node to delete found
            return doDelete(current);
        }
        if (node.value.compareTo(current.value) < 0) {
            current.left = deleteRecursive(current.left, node);
            return current;
        }
        current.right = deleteRecursive(current.right, node);
        return current;
    }

    private Node<T> doDelete(Node<T> current) {
        if (current.left == null && current.right == null) {
            return null;
        }

        if (current.right == null) {
            return current.left;
        }

        if (current.left == null) {
            return current.right;
        }

        Node<T> smallestValue = findSmallestValue(current.right);
        current = smallestValue;
        current.right = deleteRecursive(current.right, smallestValue);
        return current;
    }

    private Node<T> findSmallestValue(Node<T> node) {
        return node.left == null ? node : findSmallestValue(node.left);
    }
}
