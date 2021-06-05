package LeetCode19;

// 先求出链表的size/length
public class Solution1 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        assert n >= 0;

        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size ++;
            cur = cur.next;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        for (int i = 0; i < size - n; i ++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;

        return dummyHead.next;
    }
}
