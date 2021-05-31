package LeetCode2;

import java.util.ArrayList;
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1 = l1, p2 = l2;
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        int carried = 0;

        while (p1 != null || p2 != null) {
            int a = p1 != null ? p1.val : 0;
            int b = p2 != null ? p2.val : 0;
            cur.next = new ListNode((a + b + carried) % 10);

            carried = (a + b + carried) / 10;

            cur = cur.next;

            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;
        }

        cur.next = carried > 0 ? new ListNode(1) : null;
        return dummyHead.next;
    }
}
