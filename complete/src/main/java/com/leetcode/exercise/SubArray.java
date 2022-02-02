package com.leetcode.exercise;

import java.util.*;
import java.util.stream.IntStream;

public class SubArray {
    int[] nums;

    public int maxSubArray(int[] nums) {
        this.nums = nums;
        return findMax(0, nums.length - 1);
    }

    int findMax(int i, int j) {
        if (i > j) return Integer.MIN_VALUE;
        if (i == j) return nums[i];
        int mid = (int) (i + j)/2;
        int maxLeft = findMax(i, mid);
        int maxRight = findMax(mid + 1, j);

        int maxLeftFromMid = Integer.MIN_VALUE;
        int runningSum = 0;
        for (int p = mid; p >= i; p--) {
            runningSum += nums[p];
            if (runningSum > maxLeftFromMid) maxLeftFromMid = runningSum;
        }

        int maxRightFromMid = Integer.MIN_VALUE;
        runningSum = 0;
        for (int p = mid + 1; p <= j; p++) {
            runningSum += nums[p];
            if (runningSum > maxRightFromMid) maxRightFromMid = runningSum;
        }

        return Math.max(Math.max(maxLeft, maxRight),
                ((maxLeftFromMid > 0 || maxRightFromMid > 0) ? (maxLeftFromMid > 0 ? maxLeftFromMid : 0) + (maxRightFromMid > 0 ? maxRightFromMid : 0) : Integer.MIN_VALUE));
    }

    public int maxSubArrayGreedy(int[] nums) {
        int max = Integer.MIN_VALUE;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            current = Math.max(current + nums[i], nums[i]);
            max = Math.max(max, current); // find max in dp
        }
        return max;
    }

    public int maxSubArrayRecursion(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        int maxSum = Integer.MIN_VALUE;
        int iRight = 0;
        int iLeft = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxSum) {
                maxSum = nums[i];
                iLeft = i;
                iRight = i;
            }
        }
        int[] temp = nums;
        while(temp.length > 1) {
            int[] temp2 = new int[temp.length -1];
            for (int i = 0; i < temp.length - 1; i++) {
                int iNums = i + nums.length - temp.length +1;
                temp2[i] = temp[i] + nums[iNums];
                if (temp2[i] > maxSum) {
                    maxSum = temp2[i];
                    iLeft = i;
                    iRight = iNums;
                }
            }
            temp = temp2;
        }

        Integer[] array =  IntStream.range(iLeft, iRight + 1)
                .mapToObj(i -> nums[i])
                .toArray(Integer[]::new);

        System.out.println(Arrays.asList(array));
        return maxSum;
    }

    public int maxProduct(int[] nums) {
        return findMaxProduct(nums, 0, nums.length - 1);
    }

    private int findMaxProduct(int[] a, int i, int j) {
        if (i > j) return Integer.MIN_VALUE;
        if (i == j) return a[i];
        int mid = (int) (i + j)/2;
        int maxLeft = findMaxProduct(a, i, mid);
        int maxRight = findMaxProduct(a, mid + 1, j);

        int maxLeftFromMidPos = 0;
        int maxLeftFromMidPNeg = 0;
        int runningProduct = 1;
        for (int p = mid; p >= i; p--) {
            runningProduct *= a[p];
            if (runningProduct > 0 && runningProduct > maxLeftFromMidPos) {
                maxLeftFromMidPos = runningProduct;
            } else if (runningProduct < 0 && runningProduct < maxLeftFromMidPNeg) {
                maxLeftFromMidPNeg = runningProduct;
            }
        }

        int maxRightFromMidPos = 0;
        int maxRightFromMidNeg = 0;
        runningProduct = 1;
        for (int p = mid + 1; p <= j; p++) {
            runningProduct *= a[p];
            if (runningProduct > 0 && runningProduct > maxRightFromMidPos) {
                maxRightFromMidPos = runningProduct;
            } else if (runningProduct < 0 && runningProduct < maxRightFromMidNeg) {
                maxRightFromMidNeg = runningProduct;
            }
        }

        int maxBoth = Math.max(maxLeftFromMidPos, maxRightFromMidPos);
        if (maxLeftFromMidPos * maxRightFromMidPos > maxBoth) {
            maxBoth = maxLeftFromMidPos * maxRightFromMidPos;
        }
        if (maxLeftFromMidPNeg * maxRightFromMidNeg > maxBoth) {
            maxBoth = maxLeftFromMidPNeg * maxRightFromMidNeg;
        }

        return Math.max(Math.max(maxLeft, maxRight), maxBoth);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            int index = i;
            while (index < nums.length && prod * nums[index] < k) {
                count++;
                prod *= nums[index];
                index++;
            }
        }
        return count;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> dup = new HashSet<>();
        for (int i = 0; i < s.length() - 10 + 1; i++) {
            String sub = s.substring(i, i + 10);
            if (seen.contains(sub)) {
                dup.add(sub);
            } else {
                seen.add(sub);
            }
        }

        return seen.isEmpty() ? null : new ArrayList<>(dup);
    }

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) return "";
        Stack<String> stack = new Stack<String>();
        int i = 0;
        StringBuffer b = new StringBuffer();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ' || i == s.length() -1) {
                if (b.length() > 0) {
                    stack.push(b.toString());
                    b = new StringBuffer();
                }
            } else {
                b.append(c);
            }
            i++;
        }

        StringBuffer out = new StringBuffer();
        while(!stack.isEmpty()) {
            out.append(stack.pop()).append(" ");
        }
        out.deleteCharAt(b.length() -1);
        return out.toString();
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (k >= arr.length) return 0;

        Map<Integer, Integer> cMap = new HashMap<>();

        for (int i: arr) {
            if (!cMap.containsKey(i)) cMap.put(i, 0);
            cMap.put(i, cMap.containsKey(i) ? cMap.get(i) + 1 : 1);
        }

        int[] counts = new int[cMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : cMap.entrySet()) {
            counts[i++] = entry.getValue();
        }

        Arrays.sort(counts);

        i = 0;
        while (k > 0 && i < counts.length) {
            k -= counts[i];
            if (k >= 0) i++;
        }
        return counts.length - i;
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> cSet = new HashSet<>();
        Queue<Character> cQueue = new LinkedList<>();
        int max = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cSet.contains(c)) {
                char pulled = cQueue.remove();
                while( pulled != c){
                    cSet.remove(pulled);
                    pulled = cQueue.remove();
                }
            }
            cSet.add(c);
            cQueue.add(c);
            if (cQueue.size() > max) max = cQueue.size();
        }
        return max;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        int i = 0; int j = 0;
        while(j <= nums.length) {
            if (sum >= k) {
                if (sum == k) count++;
                sum -= nums[i++];
            } else {
                sum += nums[j++];
            }
        }
        return count;
    }
}
