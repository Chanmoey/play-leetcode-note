package LeetCode155;

public class MinStack {

    int capacity;
    int top;
    int minIndex;
    int[] stack;

    public MinStack() {
        this.capacity = 1000;
        this.top = -1;
        this.stack = new int[capacity];
    }

    public void push(int val) {
        if (this.top == capacity - 1) {
            this.expansion();
        }
        this.stack[++this.top] = val;
        if (this.top == 0) {
            this.minIndex = 0;
        } else {
            if (val < this.stack[this.minIndex]) {
                this.minIndex = top;
            }
        }
    }

    public void pop() {
        if (this.top == this.minIndex) {
            this.findMinIndex(this.top - 1);
        }
        this.top--;
    }

    public int top() {
        return this.stack[top];
    }

    public int getMin() {
        return this.stack[this.minIndex];
    }

    private void expansion() {
        this.capacity *= 2;
        int[] newStack = new int[this.capacity];
        if (this.top + 1 >= 0) {
            System.arraycopy(this.stack, 0, newStack, 0, this.top + 1);
        }
        this.stack = newStack;
    }

    private void findMinIndex(int end) {
        if (this.top == -1) {
            this.minIndex = -1;
            return;
        }
        this.minIndex = 0;
        for (int i = 0; i <= end; i++) {
            if (this.stack[i] < this.stack[this.minIndex]) {
                this.minIndex = i;
            }
        }
    }
}
