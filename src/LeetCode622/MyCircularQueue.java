package LeetCode622;

/**
 * 需要一个多余的空间
 *
 * @author Chanmoey
 * @date 2022年09月25日
 */
class MyCircularQueue {

    private final int[] arr;
    int capacity;

    // when font == rear -> queue is empty.
    int font = 0;
    int rear = 0;

    public MyCircularQueue(int k) {
        this.arr = new int[k + 1];
        this.capacity = k + 1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        this.arr[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        font = (font + 1) % capacity;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return arr[font];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return arr[(capacity + rear - 1) % capacity];
    }

    public boolean isEmpty() {
        return rear == font;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == font;
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.Rear();
        queue.isFull();
        queue.deQueue();
        queue.enQueue(4);
        queue.Rear();
    }
}
