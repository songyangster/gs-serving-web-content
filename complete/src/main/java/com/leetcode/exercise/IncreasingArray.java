package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.*;

import java.util.*;

public class IncreasingArray {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int count = 0;
        int index2 = 0;
        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i] < arr1[i-1]) {
                while (index2 < arr2.length) {
                    if (arr2[index2] >= arr1[i -1]) {
                        arr1[i] = arr2[index2];
                        index2++;
                        count++;
                        break;
                    } else {
                        index2++;
                    }
                }
                return -1;
            }
        }
        return count;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) return new int[][]{{newInterval[0], newInterval[1]}};
        Interval newIt = new Interval(newInterval);
        List<Interval> iList = new ArrayList<>();
        boolean isInserted = false;
        boolean isLess = true;
        for (int[] inte : intervals) {
            Interval interval = new Interval(inte);
            boolean merged = newIt.merge(interval);
            if (merged) {
                if (!isInserted) {
                    iList.add(newIt);
                    isInserted = true;
                }
            } else {
                if (newIt.compareTo(interval) < 0 && !isInserted) {
                    isInserted = true;
                    iList.add(newIt);
                }
                iList.add(interval);
            }
        }
        if (!isInserted) {
            isInserted = true;
            iList.add(newIt);
        }

        int[][] val = iListToArray(iList);
        return val;
    }

    private int[][] iListToArray(List<Interval> iList) {
        int[][] val = new int[iList.size()][2];
        for (int i = 0; i < iList.size(); i++) {
            val[i] = iList.get(i).getInterval();
        }
        return val;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return intervals;
        List<Interval> iL = new ArrayList<>();
        for (int[] interval : intervals) {
            iL.add(new Interval(interval));
        }
        Collections.sort(iL);

        List<Interval> iList = new ArrayList<>();
        Iterator<Interval> iterator = iL.iterator();
        Interval intervalPre = iterator.next();
        iList.add(intervalPre);
        while(iterator.hasNext()) {
            Interval current = iterator.next();
            boolean isMerged = intervalPre.merge(current);
            if (!isMerged) {
                iList.add(current);
                intervalPre = current;
            }
        }

        return iListToArray(iList);
    }

    public int[][] merge1(int[][] intervals) {
        Graph g = new Graph();
        Vertex<int[]>[] vertices = new Vertex[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            Vertex<int[]> vertex = new Vertex(interval);
            vertices[i] = vertex;
            g.addVertex(vertex);
        }

        for (int i = 0; i < vertices.length -1; i++) {
            int j = i + 1;
            while (j < vertices.length && isConnected(vertices[i], vertices[j])) {
               g.addEdge(vertices[i], vertices[j]);
               j++;
            }
        }

        Set<Vertex> visited = new HashSet<>();
        List<int[]> newIntervals = new ArrayList<>();
        for (int i = 0; i < vertices.length; i++) {
            Vertex<int[]> v = vertices[i];
            if (!visited.contains(v)) {
                Set<Vertex>  vd = g.breadthFirstTraversal(v);
                visited.addAll(vd);
                newIntervals.add(getMerged(vd));
            }
        }

        int[][] val = new int[newIntervals.size()][];
        for (int i = 0; i < val.length; i++) {
            val[i] = newIntervals.get(i);
        }
        return val;
    }

    private int[] getMerged(Set<Vertex> visited) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Vertex v : visited) {
            if (((int[]) v.getValue())[0] < min ) min = ((int[]) v.getValue())[0];
            if (((int[]) v.getValue())[1] > max ) max = ((int[]) v.getValue())[1];
        }
        return new int[]{min, max};
    }
    private boolean isConnected(Vertex<int[]> v1, Vertex<int[]> v2) {
        return (Math.max(v1.getValue()[1], v2.getValue()[1]) -  Math.min(v1.getValue()[0], v2.getValue()[0]))
                <=  v1.getValue()[1] - v1.getValue()[0] + v2.getValue()[1] - v2.getValue()[0];
    }
}
