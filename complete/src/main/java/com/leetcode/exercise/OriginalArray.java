package com.leetcode.exercise;

import java.util.*;

public class OriginalArray {
    public int[] findOriginalArray(int[] changed) {
        if (changed == null || changed.length < 2) return new int[0];
        Arrays.sort(changed);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : changed) {
            if (!countMap.containsKey(i)) {
                countMap.put(i, 1);
            } else {
                countMap.put(i, countMap.get(i) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = changed.length - 1; i> 0; i--){
            int keyDouble = changed[i];
            if (countMap.containsKey(keyDouble) && keyDouble %2 == 0 && countMap.containsKey(keyDouble /2)) {
                decrementCount(countMap, keyDouble);
                if (countMap.containsKey(keyDouble /2)) {
                    decrementCount(countMap, keyDouble / 2);
                    result.add(keyDouble / 2);
                }
            }
        }
        return countMap.isEmpty() ? result.stream().mapToInt(i -> i).toArray() : new int[0];
    }

    private void decrementCount(Map<Integer, Integer> countMap, int keyDouble) {
        if (countMap.get(keyDouble) > 1) {
            countMap.put(keyDouble, countMap.get(keyDouble) - 1);
        } else {
            countMap.remove(keyDouble);
        }
    }
}
