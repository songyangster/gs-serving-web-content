package com.leetcode.exercise.datastructure;

import java.util.Objects;

public class Interval implements Comparable{
    private int begin;
    private int end;

    public Interval(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    public Interval(int[] interval) {
        this.begin = interval[0];
        this.end = interval[1];
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public int[] getInterval() {
        return new int[]{begin, end};
    }

    public int length() {
        return end - begin;
    }

    public boolean merge(Interval o) {
        int lower = Math.min(this.begin, o.begin);
        int upper = Math.max(this.end, o.end);
        if (upper - lower <= this.length() + o.length()) {
            this.begin = lower;
            this.end = upper;
            return true;
        } else {
            return false;
        }
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return begin == interval.begin && end == interval.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(begin, end);
    }

    @Override
    public String toString() {
        return "[" + begin + "," + end + "]";
    }

    @Override
    public int compareTo(Object o) {
        Interval it = (Interval) o;
        if (this.begin == it.begin) {
            return 0;
        } else if (this.begin > it.begin) {
            return 1;
        } else {
            return -1;
        }
    }
}
