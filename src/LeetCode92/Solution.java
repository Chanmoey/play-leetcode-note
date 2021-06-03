package LeetCode92;


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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) {
            return head;
        }

        if (head == null) {
            return null;
        }

        assert left < right;

        ListNode cur = head;
        ListNode pre = null;

        // seg 表示 [left...right] 中 left 的前一个结点
        ListNode seg = null;

        int i = 0;
        while (i < left && cur != null) {
            seg = pre;
            pre = cur;
            cur = cur.next;
            i++;
        }

        while (i < right && cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            i++;
        }

        if (seg == null) {
            head.next = cur;
            head = pre;
        } else {
            seg.next.next = cur;
            seg.next = pre;
        }

        return head;
    }
}
