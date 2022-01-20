package com.leetcode.exercise.datastructure;

import java.util.Objects;

/**
 * Definition for a binary tree node.
 */
public class Node<T> {
    public T value;
    public Node<T> left;
    public Node<T> right;
    public Node() {}
    public Node(T val) { this.value = val; }
    public Node(T val, Node<T> left, Node<T> right) {
        this.value = val;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
