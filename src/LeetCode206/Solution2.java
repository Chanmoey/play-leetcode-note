package LeetCode206;

/**
 * @author Chanmoey
 * @date 2022年11月18日
 */
public class Solution2 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 宏观：head后的链表已经完成了翻转，并返回翻转后的头指针
        ListNode res = reverseList(head.next);

        // 翻转
        head.next.next = head;

        return res;
    }
}
