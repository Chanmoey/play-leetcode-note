package LeetCode2095;

import listnode.ListNode;

/**
 * @author Chanmoey
 * @date 2022年10月14日
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        int size = 0;
        ListNode point = head;
        while (point != null) {
            size++;
            point = point.next;
        }

        if (size == 1) {
            return null;
        }

        int mid = size / 2;
        int idx = 0;
        point = head;
        while (idx < mid - 1) {
            point = point.next;
            idx ++;
        }

        point.next = point.next.next;
        return head;
    }
}
