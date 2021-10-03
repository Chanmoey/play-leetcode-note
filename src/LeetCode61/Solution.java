package LeetCode61;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int count = 0;
        ListNode cur = head;
        ListNode tail = null;
        while (cur != null) {
            count++;
            tail = cur;
            cur = cur.next;
        }

        k = count > k ? k : k % count;
        if (k == 0) {
            return head;
        }

        ListNode pre = null;
        ListNode newHead = head;
        for (int i = 0; i < count - k; i++) {
            pre = newHead;
            newHead = newHead.next;
        }

        assert pre != null;
        pre.next = null;
        tail.next = head;
        return newHead;
    }
}
