package LeetCode707;

/**
 * @author Chanmoey
 * @date 2022年02月15日
 */
class MyLinkedList {

    static class Node {
        private final int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this(value, null);
        }
    }

    private final Node dummyHead;
    private int size;

    public MyLinkedList() {
        this.dummyHead = new Node(Integer.MIN_VALUE);
        this.size = 0;
    }

    public int get(int index) {

        if (index >= this.size || this.size <= 0) {
            return -1;
        }

        Node res = this.dummyHead;
        for (int i = 0; i <= index; i++) {
            res = res.next;
        }

        return res.value;
    }

    public void addAtHead(int val) {
        this.dummyHead.next = new Node(val, this.dummyHead.next);
        this.size++;
    }

    public void addAtTail(int val) {
        this.addAtIndex(this.size, val);
    }

    public void addAtIndex(int index, int val) {

        if (index < 0 || index > this.size) {
            return;
        }

        Node cur = this.dummyHead;
        Node pre = null;
        for (int i = 0; i <= index; i++) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = new Node(val, cur);
        this.size++;
    }

    public void deleteAtIndex(int index) {

        if (index < 0 || index >= this.size) {
            return;
        }

        Node cur = this.dummyHead;
        Node pre = null;
        for (int i = 0; i <= index; i++) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = cur.next;
        cur.next = null;
        this.size--;
    }
}
