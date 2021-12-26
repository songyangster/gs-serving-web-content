package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.ListNode;

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

}
