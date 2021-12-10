package com.leetcode.exercise;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0, null);

        ListNode node = result;
        int overflow = 0;
        while(l1 != null || l2 != null || overflow == 1) {
            int valsum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + overflow;
            boolean isOver = false;
            if (valsum > 9) {
                valsum -= 10;
                isOver = true;
            }
            node.val = valsum;
            overflow = isOver ? 1 : 0;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            node.next = (l1 != null || l2 != null || overflow == 1) ? new ListNode(0, null) : null;
            node = node.next;
        }
        node = null;

        return result;
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

}
