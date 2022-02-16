package com.leetcode.exercise.datastructure;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static long sumdNodes(ListNode node) {
        long sum = 0;
        long base = 1;
        while (node != null) {
            sum += node.val * base;
            node = node.next;
            base *= 10;
        }
        return sum;
    }

    public static ListNode convertToListNode(int[] list) {
        ListNode node = null;
        for (int i = list.length - 1; i >= 0; i--) {
            node = new ListNode(list[i], node == null ? null : node);
        }
        return node;
    }

    public static int[] convertToInt(ListNode node) {
        if (node == null) return new int[0];
        List<Integer> list = new ArrayList<>();

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        if (this.next == null && listNode.next == null) {
            return val == listNode.val;
        } else if (this.next == null || listNode.next == null){
            return false;
        } else {
            return this.next.equals(listNode.next);
        }
    }
}
