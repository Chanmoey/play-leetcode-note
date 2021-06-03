package LeetCode82;

public class Solution1 {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode cur = prev.next;

        while(cur != null) {

            int num = 0;
            ListNode p = cur;
            while (p != null && p.val == cur.val){
                num ++;
                p = p.next;
            }

            if (num > 1){
                prev.next = p;
            }
            else {
                prev = cur;
            }

            cur = p;
        }

        return dummyHead.next;
    }
}
