package com.leetcode.exercise;

import java.util.LinkedList;

public class BoundedBlockingQueue {
    private int capacity;
    private LinkedList<Integer> queue;
    private Object lock = new Object();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<Integer>();
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized (lock) {
            while (queue.size() >= capacity) {
                lock.wait();
            }
            lock.notifyAll();
                queue.push(element);
         }
    }

    public int dequeue() throws InterruptedException {
        synchronized (lock) {
            while (queue.size() == 0) {
                lock.wait();
            }
            lock.notifyAll();
            return queue.removeLast();
        }
    }

    public int size() {
        return queue.size();
    }
}
