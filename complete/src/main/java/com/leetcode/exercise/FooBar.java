package com.leetcode.exercise;

import java.util.concurrent.atomic.AtomicBoolean;

public class FooBar {
    private int n;
    private AtomicBoolean iSFoo = new AtomicBoolean(false);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(this.iSFoo.get()) {
                Thread.sleep(100);
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            this.iSFoo.getAndSet(true);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(!this.iSFoo.get()) {
                Thread.sleep(100);
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            this.iSFoo.getAndSet(false);
        }
    }
}
