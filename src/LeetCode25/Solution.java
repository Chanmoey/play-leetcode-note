package LeetCode25;

import java.util.List;

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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        while (pre != null && pre.next != null) {

            ListNode end = pre;
            int i;
            for (i = 0; i < k && end.next != null; i ++) {
                end = end.next;
            }

            if (i != k) {
                break;
            }

            ListNode next = end.next;

            ListNode rhead = this.reverse(pre.next, end);

            ListNode tail = pre.next;
            pre.next = rhead;
            tail.next = next;
            pre = tail;
        }

        return dummyHead.next;
    }

    private ListNode reverse(ListNode head, ListNode end) {
        if (head == end) {
            return head;
        }

        ListNode rhead = reverse(head.next, end);
        head.next.next = head;
        return rhead;
    }
}
