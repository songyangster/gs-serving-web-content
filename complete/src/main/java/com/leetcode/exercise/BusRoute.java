package com.leetcode.exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BusRoute {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, Set<Integer>> stopToRoute = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int j = 0; j < route.length; j++) {
                int stop = route[j];
                if (!stopToRoute.containsKey(stop)) {
                    stopToRoute.put(stop, new HashSet<>());
                }
                stopToRoute.get(stop).add(i);
            }
        }

        int r = 1;
        Set<Integer> targetR = stopToRoute.get(target);
        if (targetR == null) return -1;

        Set<Integer> stopSet = new HashSet<Integer>(){{add(source);}};
        Set<Integer> routeSet = stopToRoute.get(source);
        Set<Integer> intersectionSet = new HashSet<Integer>();
        intersectionSet.addAll(routeSet);
        intersectionSet.retainAll(targetR);

        while(intersectionSet.isEmpty()) {
            stopSet = new HashSet<>();
            for (int routeId : routeSet) {
                for (int stop: routes[routeId]) {
                    stopSet.add(stop);
                }
            }
            int routeCount = routeSet.size();
            for (int stop : stopSet) {
                routeSet.addAll(stopToRoute.get(stop));
            }
            if (routeCount == routeSet.size()) return -1;

            r++;
            intersectionSet = new HashSet<Integer>();
            intersectionSet.addAll(routeSet);
            intersectionSet.retainAll(targetR);
            if (!intersectionSet.isEmpty()) return r;
        }

        return r;
    }
}
