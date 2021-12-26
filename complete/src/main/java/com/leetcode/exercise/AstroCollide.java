package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.ListNode;

public class AstroCollide {
    public int[] asteroidCollision(int[] asteroids) {
        ListNode astroList = ListNode.convertToListNode(asteroids);

        while (iterateList(astroList)) {

        }
        return null;
    }

    private boolean iterateList(ListNode node) {
        boolean collide = false;
        while (node.next != null) {
            ListNode next = node.next;
            if (node.val > 0 && next.val < 0) {
                collide = true;
                if (node.val == -next.val) {
                    node.val = 0;
                } else {
                    if (node.val < -next.val) {
                        node.val = -next.val;
                    }
                }
                node.next = next.next;
            } else if (next.val == 0) {
                node.next = next.next;
            }
            node = node.next;
        }
        return collide;
    }
}
