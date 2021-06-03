package LeetCode83;


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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;

        while (cur.next != null) {
            ListNode next = cur.next;
            if (next.val == cur.val) {
                cur.next = next.next;
                next = null;
            } else {
                cur = next;
            }
        }

        return head;
    }
}