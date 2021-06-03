package LeetCode147;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode cur = head;
        ListNode curPrev = dummyHead;

        while(cur != null) {
            ListNode prev = dummyHead;
            ListNode index = null;
            while (prev != cur) {
                if (prev.next.val > cur.val) {
                    index = prev.next;
                    break;
                } else {
                    prev = prev.next;
                }
            }

            if (index != null) {
                prev.next = cur;
                curPrev.next = cur.next;
                cur.next = index;
                cur = curPrev;
            }

            curPrev = cur;
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
