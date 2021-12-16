package LeetCode23;

import listnode.ListNode;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length <= 0) {
            return null;
        }
        ListNode ret = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ret = this.merge(ret, lists[i]);
        }

        return ret;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
            p.next = null;
        }
        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }

        return dummyHead.next;
    }
}