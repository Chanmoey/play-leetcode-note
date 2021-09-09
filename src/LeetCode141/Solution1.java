package LeetCode141;

import ListNode.ListNode;

/**
 * 已知-10^5 <= Node.val <= 10^5，
 * 每访问一次Node，将其val改为这个范围外的数字x，
 * 当某一Node.val为x时，这说明出现了循环。
 */
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        ListNode point = head;
        int outOfRange = 1000001;
        while (point != null) {
            if (point.val == outOfRange) {
                return true;
            }
            point.val = outOfRange;
            point = point.next;
        }

        return false;
    }
}
