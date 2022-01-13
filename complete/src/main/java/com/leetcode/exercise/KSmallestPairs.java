package com.leetcode.exercise;

import java.util.*;

public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> val = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int count = 1;
        int i1 = 0, i2 = 0;
        val.add(Arrays.asList(nums1[i1], nums2[i2]));
        while (count < k && (i1 < nums1.length || i2 < nums2.length)) {
            if (i1 < nums1.length - 1 && i2 < nums2.length -1) {
                if ((nums1[i1 + 1] + nums2[i2]) < (nums1[i1] + nums2[i2 + 1]) || (nums1[i1 + 1] + nums2[i2]) == (nums1[i1] + nums2[i2])) {
                    i1++;
                } else {
                    i2++;
                }
            } else if (i2 >= nums2.length - 1) {
                i1++;
            } else if (i1 >= nums1.length - 1) {
                i2++;
            } else {
                System.out.println("Should not reach here!!!!!");
            }
            val.add(Arrays.asList(nums1[i1], nums2[i2]));
            count++;
        }

        return val;
    }

    public int[][] kClosest(int[][] points, int k) {
        TreeMap<Integer, Set<Point>> map = new TreeMap<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int distance = x * x + y * y;
            if (!map.containsKey(distance)) {
                map.put(distance, new HashSet<>());
            }
            Set<Point> set = map.get(distance);
            set.add(new Point(point));
        }

        int[][] val = new int[k][];
        Iterator<Map.Entry<Integer, Set<Point>>> iterator = map.entrySet().iterator();
        int i = 0;
        while (i < k && iterator.hasNext()) {
            Set<Point> set = iterator.next().getValue();
            Iterator<Point> iterator1 = set.iterator();
            while (i < k && iterator1.hasNext()) {
                val[i] =  iterator1.next().getPoint();
                i++;
            }
        }
        return val;
    }

    private static class Point {
        int[] point;

        public Point(int[] point) {
            this.point = point;
        }

        public int[] getPoint() {
            return point;
        }
    }

}
