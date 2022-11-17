package LeetCode206;

/**
 * @author Chanmoey
 * @date 2022年11月18日
 */
public class Solution1 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        return reverseList(null, head);
    }

    private ListNode reverseList(ListNode pre, ListNode node) {
        if (node.next == null) {
            node.next = pre;
            return node;
        }

        ListNode next = node.next;
        node.next = pre;

        return reverseList(node, next);
    }
}
