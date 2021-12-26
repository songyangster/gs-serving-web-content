package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.ListNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestAddTwoNumbers {
    @Test
    public void testAddTwoNumbers() {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        compareAdds(addTwoNumbers, new int[]{2,4,3}, new int[]{5,6,4}, new int[]{7,0,8});
        compareAdds(addTwoNumbers, new int[]{9,9,9,9,9,9,9}, new int[]{9,9,9,9}, new int[]{8,9,9,9,0,0,0,1});
        compareAdds(addTwoNumbers, new int[]{0}, new int[]{0}, new int[]{0});
        compareAdds(addTwoNumbers, new int[]{9}, new int[]{1,9,9,9,9,9,9,9,9,9}, new int[]{0,0,0,0,0,0,0,0,0,0,1});
    }

    private void compareAdds(AddTwoNumbers addTwoNumbers, int[] l1, int[] l2, int[] expected) {
        ListNode l11 = ListNode.convertToListNode(l1);
        ListNode l12 = ListNode.convertToListNode(l2);
        ListNode sum = addTwoNumbers.addTwoNumbers(l11, l12);

        long sumExpected = 0;
        long base = 1;
        for (int entry : expected) {
            sumExpected += entry * base;
            base *= 10;
        }
        assertEquals(ListNode.sumdNodes(sum), sumExpected);
    }
}
