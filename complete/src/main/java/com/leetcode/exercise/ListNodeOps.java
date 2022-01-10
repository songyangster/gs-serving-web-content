package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.ListNode;

public class ListNodeOps {
    public ListNode rotateRight(ListNode head, int k) {
        int cCount = 0;
        ListNode current = head;
        ListNode newHead = null;

        while (current.next != null ) {
            cCount++;
            if (cCount == k) {
                newHead = current;
            }
            if (current.next == null) {
                current.next = head;
                if (newHead != null) return newHead;
                k = k % cCount;
                cCount = 0;
            }
        }
        return newHead;
    }
}
