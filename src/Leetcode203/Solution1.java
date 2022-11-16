package Leetcode203;

/**
 * 使用递归
 *
 * @author Chanmoey
 * @date 2022年11月17日
 */
public class Solution1 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode next = removeElements(head.next, val);

        if (head.val == val) {
            head.next = null;
            return next;
        } else {
            head.next = next;
            return head;
        }
    }
}
