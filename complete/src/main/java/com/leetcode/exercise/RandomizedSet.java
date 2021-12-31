package com.leetcode.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int lastEntry = list.get(list.size() - 1);
            int index = map.get(val);
            list.set(index, lastEntry);
            map.put(lastEntry, index);
            list.remove(list.size() - 1);
            map.remove(val);

            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int random = (int) Math.random() * (list.size());
        return list.get(random);
    }
}
