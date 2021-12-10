package com.leetcode.exercise;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestTwoSums {
    @Test
    public void testSolution() {
        TwoSum solution = new TwoSum();
        compareResults(solution, new int[]{2,7,11,15}, new int[]{0, 1}, 9);
        compareResults(solution, new int[]{3,2,4}, new int[]{1, 2}, 6);
        compareResults(solution, new int[]{3, 3}, new int[]{0, 1}, 6);
    }

    private void compareResults(TwoSum solution, int[] nums, int[] expected, int sum) {
        int[] results = solution.twoSum(nums, sum);
        assert(Arrays.equals(expected, results));
    }
}
