package com.leetcode.exercise;

import java.util.*;

public class AllOne {
    private Map<String, Integer> sMap;
    private TreeMap<Integer, Set<String>> cMap;

    public AllOne() {
        sMap = new HashMap<>();
        cMap = new TreeMap<>();
    }

    public void inc(String key) {
        if (!sMap.containsKey(key)) {
            sMap.put(key, 0);
        }
        int count = sMap.get(key);
        sMap.put(key, count + 1);

        if (count > 0) {
            Set<String> sSet = cMap.get(count);
            sSet.remove(key);
            if (sSet.isEmpty()) cMap.remove(count);
        }
        if (!cMap.containsKey(count + 1)) {
            cMap.put(count + 1, new HashSet<>());
        }
        Set<String> set = cMap.get(count + 1);
        set.add(key);
    }

    public void dec(String key) {
        Integer count = sMap.get(key);
        if (count == null) return;
        if (count > 0) {
            sMap.put(key, count - 1);
        } else {
            sMap.remove(key);
        }

        if (count > 0) {
            Set<String> sSet = cMap.get(count);
            sSet.remove(key);
            if (sSet.isEmpty()) cMap.remove(count);
        }
        if (count > 1) {
            if (!cMap.containsKey(count - 1)) {
                cMap.put(count - 1, new HashSet<>());
            }
            Set<String> set = cMap.get(count - 1);
            set.add(key);
        }
    }

    public String getMaxKey() {
        if (cMap.isEmpty()) return "";
        for(String s : cMap.get(cMap.lastKey())) {
            return s;
        };
        return "";
    }

    public String getMinKey() {
        if (cMap.isEmpty()) return "";
        for (String s : cMap.get(cMap.firstKey())) {
            return s;
        };
        return "";
    }

}
