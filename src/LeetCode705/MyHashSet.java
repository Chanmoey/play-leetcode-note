package LeetCode705;

/**
 * @author Chanmoey
 * @date 2022年04月21日
 */
class MyHashSet {

    private static class SetNode {
        int value;
        SetNode next;

        public SetNode(int value) {
            this.value = value;
        }

        public SetNode(int value, SetNode node) {
            this.value = value;
            this.next = node;
        }
    }

    private final SetNode[] arr = new SetNode[10000];

    public MyHashSet() {
    }

    public void add(int key) {
        if (contains(key)) {
            return;
        }
        int idx = key % arr.length;
        if (this.arr[idx] == null) {
            this.arr[idx] = new SetNode(key);
        } else {
            SetNode pre = this.arr[idx];
            while (pre.next != null) {
                pre = pre.next;
            }
            pre.next = new SetNode(key);
        }
    }

    public void remove(int key) {
        int idx = key % arr.length;
        if (!contains(key)) {
            return;
        }
        SetNode dummyHead = new SetNode(-1, this.arr[idx]);
        SetNode pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.value == key) {
                pre.next = pre.next.next;
                break;
            }
            pre = pre.next;
        }
        this.arr[idx] = dummyHead.next;
    }

    public boolean contains(int key) {
        int idx = key % arr.length;
        if (this.arr[idx] == null) {
            return false;
        }

        SetNode pointer = this.arr[idx];
        while (pointer != null) {
            if (pointer.value == key) {
                return true;
            }
            pointer = pointer.next;
        }

        return false;
    }
}
