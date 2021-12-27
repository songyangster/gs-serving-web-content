package com.leetcode.exercise;

import java.util.*;

public class FactorCombo {
    Map<Integer, List<List<Integer>>> dp = new HashMap<>();

    public List<List<Integer>> getFactors(int n) {
        if (!dp.containsKey(n)) {
            dp.put(n, new ArrayList<>());
//            Set<Integer> visited = new HashSet<>();
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    int factor = n / i;
                    List<List<Integer>> dpS = new ArrayList<>();
//                    boolean doIt = true;
//                    for (int v : visited) {
//                        if (factor % v == 0) doIt = false;
//                    }
//                    if (doIt) {
                        List<List<Integer>> factors = getFactors(factor);
                        List<List<Integer>> factorsCopy = new ArrayList<>();
                        for (List<Integer> sublist : factors) {
                            factorsCopy.add(new ArrayList<>(sublist));
                        }
                        dpS.addAll(factorsCopy);
//                    }
                        List<Integer> e = new ArrayList<>();
                        e.add(factor);
                        dpS.add(e);
                        for (List<Integer> s : dpS) {
                            s.add(i);
                        }
                        dp.get(n).addAll(dpS);
//                        visited.add(i);
                }
            }
            dp.put(n, removeDup(dp.get(n)));
        }
        return dp.get(n);
    }

    private List<List<Integer>> removeDup(List<List<Integer>> dpS) {
        List<List<Integer>> val = new ArrayList<>();
        for (int i = 0; i < dpS.size(); i++) {
            boolean dup = false;
            for (int j = i + 1; j < dpS.size(); j++) {
                if (compareList(dpS.get(i), dpS.get(j))) {
                    dup = true;
                    break;
                }
            }
            if (!dup) val.add(dpS.get(i));
        }
        return val;
    }

    private boolean compareList(List<Integer> l1, List<Integer> l2) {
        if (l1.size() != l2.size()) return false;
        Collections.sort(l1);
        Collections.sort(l2);
        return l1.equals(l2);
    }
}
