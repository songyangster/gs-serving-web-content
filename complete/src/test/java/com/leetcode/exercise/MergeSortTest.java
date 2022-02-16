package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.ListNode;
import com.leetcode.exercise.utilities.JSONConverter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MergeSortTest {
    MergeSort mergeSort = new MergeSort();

    @Test
    public void testMergeSort() {
        assertEquals (ListNode.convertToListNode(new int[]{1,1,2,3,4,4}),
                mergeSort.mergeTwoLists(ListNode.convertToListNode(new int[]{1, 2,4}), ListNode.convertToListNode(new int[]{1, 3,4})));
        assertEquals (ListNode.convertToListNode(new int[]{}),
                mergeSort.mergeTwoLists(ListNode.convertToListNode(new int[]{}), ListNode.convertToListNode(new int[]{})));
        assertEquals (ListNode.convertToListNode(new int[]{0}),
                mergeSort.mergeTwoLists(ListNode.convertToListNode(new int[]{}), ListNode.convertToListNode(new int[]{0})));

        assertEquals (ListNode.convertToListNode(new int[]{1,1,2,3,4,4,5,6}),
                mergeSort.mergeKLists(new ListNode[]{ListNode.convertToListNode(new int[]{1,4,5}),
                        ListNode.convertToListNode(new int[]{1,3,4}),
                        ListNode.convertToListNode(new int[]{2,6})}));
        assertEquals (ListNode.convertToListNode(new int[]{}),
                mergeSort.mergeKLists(new ListNode[]{}));
        assertEquals (ListNode.convertToListNode(new int[]{}),
                mergeSort.mergeKLists(new ListNode[]{ListNode.convertToListNode(new int[]{})}));
    }

    @Test
    public void testMerge() throws Exception {
        mergeSort.merge(JSONConverter.convertJSONtoIntArray("[2,0]"), 1, JSONConverter.convertJSONtoIntArray("[1]"), 1);
        assertEquals("[1, 2]", (Arrays.stream(mergeSort.nums).boxed().collect(Collectors.toList()).toString()));

        mergeSort.merge(JSONConverter.convertJSONtoIntArray("[0]"), 0, JSONConverter.convertJSONtoIntArray("[1]"), 1);
        assertEquals("[1]", (Arrays.stream(mergeSort.nums).boxed().collect(Collectors.toList()).toString()));
    }

    @Disabled
    @Test
    public void testFindMedianSortedArray() {
        assertTrue(Math.abs( mergeSort.findMedianSortedArrays(JSONConverter.convertJSONtoIntArray("[1,3]"), JSONConverter.convertJSONtoIntArray("[2]")) - 2) > 0);
    }
}
