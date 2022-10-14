package LeetCode2095;

import listnode.ListNode;

/**
 * @author Chanmoey
 * @date 2022年10月14日
 */
class Solution1 {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (pre == null) {
            return null;
        }

        pre.next = slow.next;
        return head;
    }
}
