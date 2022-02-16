package com.leetcode.exercise;

import com.leetcode.exercise.datastructure.ListNode;

import java.util.*;

public class MergeSort {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = null;
        ListNode last = null;
        while (list1 != null || list2 != null) {
            ListNode current = new ListNode();
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    current.val = list1.val;
                    list1 = list1.next;
                } else {
                    current.val = list2.val;
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                current.val = list1.val;
                list1 = list1.next;
            } else {
                current.val = list2.val;
                list2 = list2.next;
            }
            if (last != null) last.next = current;
            if (merged == null) {
                merged = current;
            }
            last = current;
        }
        return merged;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        List<ListNode> arrayList = Arrays.asList(lists);
        while (arrayList.size() > 1) {
            List<ListNode> tempList = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i = i + 2) {
                ListNode mergeTwo = i + 1 < arrayList.size() ? mergeTwoLists(arrayList.get(i), arrayList.get(i + 1)) : arrayList.get(i);
                tempList.add(mergeTwo);
            }
            arrayList = tempList;
        }
        return arrayList.get(0);
    }

    public ListNode mergeKListsLong(ListNode[] lists) {
        ListNode merged = null;
        ListNode last = null;
        while (!isEmpty(lists)) {
            ListNode min = null;
            Integer min_index = null;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node != null) {
                    if (min == null) {
                        min = node;
                        min_index = i;
                    } else {
                        if (node.val < min.val) {
                            min = node;
                            min_index = i;
                        }
                    }
                }
            }
            if (min != null) {
                ListNode current = new ListNode(min.val, null);
                if (merged == null) {
                    merged = current;
                }
                if (last != null) {
                    last.next = current;
                }
                last = current;
                lists[min_index] = min.next;
            }
        }
        return merged;
    }

    private boolean isEmpty(ListNode[] lists) {
            if (lists == null) return true;
            for (ListNode node :lists) {
                if (node != null) return false;
            }
            return true;
    }

    int[] nums;
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        this.nums = nums1;
        int[] temp = new int[m];
        for (int i = 0; i < m; i ++) {
            temp[i] = nums1[i];
        }

        int current = 0;
        int c1 = m > 0 ? 0 : 1, c2 = 0;
        while (current < m + n){
            if ((c1 < m && ((c2 < n && temp[c1] < nums2[c2]) || c2 >= n))) {
                nums1[current] = temp[c1];
                c1++;
            } else if (c2 < n){
                nums1[current] = nums2[c2];
                c2++;
            }
            current++;
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        Set<Integer> s1 = arrayToSet(nums1);
        Set<Integer> s2 = arrayToSet(nums2);
        s1.retainAll(s2);
        int[] val = new int[s1.size()];
        int i = 0;
        for (Integer e : s1) {
            val[i] = e;
            i++;
        }
        return val;
    }

    private Set<Integer> arrayToSet(int[] nums1) {
        Set<Integer> s1 = new HashSet<>();
        for (int i : nums1) {
            s1.add(i);
        }
        return s1;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0.;
        int[] num = new int[nums1.length + nums2.length];
        if (nums1.length == 0) {
            num = nums2;
        } else if (nums2.length == 0) {
            num = nums1;
        } else {
            int c1 = 0;
            int c2 = 0;
            while (c1 < nums1.length || c2 < nums2.length) {
                if ((c1 < nums1.length && nums1[c1] < nums2[c2]) || c2 == nums2.length - 1) {
                    num[c1 + c2] = nums1[c1];
                    c1++;
                } else {
                    num[c1 + c2] = nums2[c2];
                    c2++;
                }
            }
        }

        int medium = num.length/2 - 1;
        if (num.length % 2 == 0) {
            return (num[medium] + num[medium + 1]) / 2.0;
        } else {
            return num[medium];
        }
    }
}
