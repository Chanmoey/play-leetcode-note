package LeetCode160;

import ListNode.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pa = headA;
        ListNode pb = headB;
        int la = 0;
        int lb = 0;

        while (pa != null) {
            la++;
            pa = pa.next;
        }
        while (pb != null) {
            lb++;
            pb = pb.next;
        }

        pa = headA;
        pb = headB;
        int diff = Math.abs(la - lb);

        int count = 0;
        if (la > lb) {
            while (count < diff) {
                pa = pa.next;
                count++;
            }
        } else if (lb > la) {
            while (count < diff) {
                pb = pb.next;
                count++;
            }
        }

        while (pa != null) {
            if (pa == pb) {
                return pa;
            }
            pa = pa.next;
            pb = pb.next;
        }

        return null;

    }
}