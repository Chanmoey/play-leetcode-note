package LeetCode445;

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
* 通过反转链表，然后用 2. Add Two Numbers 的方式实现
* */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode reverseL1 = this.reverseList(l1);
        ListNode reverseL2 = this.reverseList(l2);

        ListNode ret = new ListNode(-1, null);

        int carry = 0;

        while (reverseL1 != null || reverseL2 != null) {
            int a = reverseL1 != null ? reverseL1.val : 0;
            int b = reverseL2 != null ? reverseL2.val : 0;

            ret.next = new ListNode((a + b + carry) % 10, ret.next);
            carry = (a + b + carry) / 10;

            reverseL1 = reverseL1 != null ? reverseL1.next : null;
            reverseL2 = reverseL2 != null ? reverseL2.next : null;
        }

        if (carry != 0) {
            ret.next = new ListNode(1, ret.next);
        }

        return ret.next;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
