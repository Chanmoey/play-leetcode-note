package LeetCode1114;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    static int flag = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        lock.lock();
        try {
            while (Foo.flag != 1) {
                condition.await();
            }

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            Foo.flag = 2;
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        lock.lock();
        try {
            while (Foo.flag != 2) {
                condition.await();
            }

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            Foo.flag = 3;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        lock.lock();
        try {
            while (Foo.flag != 3) {
                condition.await();
            }

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            Foo.flag = 1;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
