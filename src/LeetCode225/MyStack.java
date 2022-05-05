package LeetCode225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chanmoey
 * @date 2022年05月05日
 */
class MyStack {

    private final Queue<Integer> queue;

    public MyStack() {
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        this.queue.add(x);

        // 想象成转个圈，尾部变头部，头部到尾部。
        for (int i = 0; i < this.queue.size() - 1; i++) {
            this.queue.add(this.queue.remove());
        }
    }

    public int pop() {
        return this.queue.remove();
    }

    public int top() {
        assert this.queue.size() > 0;
        return this.queue.peek();
    }

    public boolean empty() {
        return this.queue.isEmpty();
    }
}
