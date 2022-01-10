package com.leetcode.exercise;

import java.util.*;

public class RandomizedCollection {
    Map<Integer, LinkedList<Integer>> map;
    List<Integer> list;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean result;
        if (map.containsKey(val)) {
            result = false;
        } else {
            map.put(val, new LinkedList<>());
            result = true;
        }
        insertVal(val);
        return result;
    }

    private void insertVal(int val) {
        map.get(val).add(list.size());
        list.add(val);
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            // Never empty
            int index = map.get(val).removeLast();
            if (map.get(val).isEmpty()) map.remove(val);

            // Put last val in the empty pace
            int lastEntryVal = list.get(list.size() - 1);
            if (lastEntryVal != val) {
                list.set(index, lastEntryVal);
                LinkedList<Integer> positions = map.get(lastEntryVal);
                positions.add(index);
                map.put(lastEntryVal, positions);
            }
            list.remove(list.size() - 1);

            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int random = (int) (Math.random() * (list.size()));
        return list.get(random);
    }
}
