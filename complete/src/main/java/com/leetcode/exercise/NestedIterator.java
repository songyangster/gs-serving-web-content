package com.leetcode.exercise;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private LinkedList<Integer> linkedList;
    private Iterator<Integer> itr;

    public NestedIterator(List<NestedInteger> nestedList) {
        linkedList = inOrder(nestedList);
        this.itr = linkedList.iterator();
    }

    private LinkedList<Integer> inOrder(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.isEmpty() ) return null;
        LinkedList<Integer> list = new LinkedList<>();
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                list.add(ni.getInteger());
            } else {
                LinkedList l = inOrder(ni.getList());
                if (l != null) list.addAll(l);
            }
        }
        return list;
    }

    @Override
    public Integer next() {
        return this.itr.next();
    }

    @Override
    public boolean hasNext() {
        return this.itr.hasNext();
    }

    public static class NestedInteger {
        public boolean isInteger(){return true;};
        public Integer getInteger(){return null;};
        public List<NestedInteger> getList(){return null;};
    }
}
