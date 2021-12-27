package com.leetcode.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KthElementArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) return 0;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        Collections.sort(list, Collections.reverseOrder());
        return list.get(k - 1);
    }
}
