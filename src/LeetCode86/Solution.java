package LeetCode86;


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

/*
* 时间复杂度O(n)
* 空间复杂度O(n)
* */

class Solution {
    public ListNode partition(ListNode head, int x) {

        if (head == null) {
            return null;
        }

        ListNode smallerDummyHead = new ListNode(-101);
        ListNode smaller = smallerDummyHead;

        ListNode greaterDummyHead = new ListNode(-101);
        ListNode greater = greaterDummyHead;

        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                smaller.next = cur;
                smaller = smaller.next;
            } else {
                greater.next = cur;
                greater = greater.next;
            }
            cur = cur.next;
        }

        greater.next = null;
        smaller.next = greaterDummyHead.next;

        return smallerDummyHead.next;
    }
}