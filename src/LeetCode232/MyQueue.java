package LeetCode232;

import java.util.Stack;

/**
 * @author Chanmoey
 * @date 2022年01月24日
 */
class MyQueue {

    private final Stack<Integer> inStack = new Stack<>();
    private final Stack<Integer> outStack = new Stack<>();
    int size = 0;

    public MyQueue() {

    }

    public void push(int x) {
        this.inStack.add(x);
        this.size ++;
    }

    public int pop() {

        this.inToOut();

        this.size --;
        return this.outStack.pop();
    }

    public int peek() {
        this.inToOut();

        return this.outStack.peek();
    }

    public boolean empty() {
        return this.size == 0;
    }

    private void inToOut() {
        if (this.outStack.isEmpty()) {
            while (!this.inStack.isEmpty()) {
                this.outStack.add(this.inStack.pop());
            }
        }
    }
}
